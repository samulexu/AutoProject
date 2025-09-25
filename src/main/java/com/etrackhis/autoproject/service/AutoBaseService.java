package com.etrackhis.autoproject.service;


import com.etrackhis.autoproject.domain.AiInterparm;
import com.etrackhis.autoproject.domain.GiDbddldefine;
import com.etrackhis.autoproject.domain.IiTradetypeinfo;
import com.etrackhis.autoproject.service.fixed.IAiInterparmService;
import com.etrackhis.autoproject.service.fixed.IGiDbddldefineService;
import com.etrackhis.autoproject.service.fixed.IIiTradetypeinfoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.*;

/**
 * description :
 * author : 徐为强
 * date : 2025-09-25 10:32
 */
@Slf4j
public class AutoBaseService {


    /** 接口的公共参数 */
    protected Map<String, Object> params;

    @Autowired
    private IGiDbddldefineService defineService;

    @Autowired
    private IAiInterparmService interParamService;

    @Autowired
    private IIiTradetypeinfoService tradeTypeInfoService;

    /** JDBC模板 */
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public AutoBaseService() {
        // 会在子类 bean 初始化前调用
    }

    /**
     * 交易前处理方法
     * 任务执行的第一步，负责数据准备和参数校验
     * @param data 待处理的数据
     * @return 处理后的数据
     */
    public Map<String, Object> preTransaction(Map<String, Object> data) {
        log.info("交易前处理开始");
        // 子类应重写此方法实现具体的交易前处理逻辑
        // 这里可以添加参数校验、数据转换等逻辑
        return data;
    }

    /**
     * 交易处理方法
     * 任务执行的第二步，负责核心交易逻辑
     * @param data 处理后的数据
     * @return 交易结果
     */
    public Map<String, Object> transaction(Map<String, Object> data) {
        log.info("交易处理开始");
        // 子类应重写此方法实现具体的交易处理逻辑
        // 这里可以调用HTTP、WebService等外部接口
        Map<String, Object> result = new HashMap<>();
        result.put("status", "success");
        result.put("message", "交易处理完成");
        return result;
    }

    /**
     * 交易后处理方法
     * 任务执行的第三步，负责交易后的处理工作
     * @param data 原始数据
     * @param result 交易结果
     * @return 处理是否成功
     */
    public boolean postTransaction(Map<String, Object> data, Map<String, Object> result) {
        log.info("交易后处理开始");
        // 子类应重写此方法实现具体的交易后处理逻辑
        // 这里可以添加数据持久化、状态更新等逻辑
        return true;
    }

    /**
     * 记录日志方法
     * @param data 请求数据
     * @param result 响应结果
     * @return 日志记录是否成功
     */
    protected boolean logTransaction(Map<String, Object> data, Map<String, Object> result) {
        log.info("记录交易日志");
        // 这里实现日志记录逻辑，可以写入数据库或文件
        // 示例代码，实际应根据需要修改
        try {
            String requestData = data != null ? data.toString() : "null";
            String responseData = result != null ? result.toString() : "null";
            log.info("交易请求: {}, 交易响应: {}", requestData, responseData);
            return true;
        } catch (Exception e) {
            log.error("记录交易日志失败: {}", e.getMessage());
            return false;
        }
    }

    /**
     * 设置参数
     * @param p 参数Map
     */
    protected void setParams(Map<String, Object> p) {
        this.params = p;
    }

    /**
     * 获取参数
     * @return 参数Map
     */
    protected Map<String, Object> getParams() {
        return this.params;
    }

    /**
     * 根据wbjkid获取接口参数
     * @param wbjkid 外部接口ID
     * @return 参数Map
     */
    protected Map<String, Object> getInterParams(String wbjkid) {
        Map<String, Object> params = new HashMap<>();

        try {
            // 从ai_interparam表中获取参数
            List<AiInterparm> interParamList = interParamService.selectList(AiInterparm.builder().wbjkid(wbjkid).build());

            for (AiInterparm param : interParamList) {
                String key = param.getJkcsyw();
                Object value = param.getJkcsnr();

                if (StringUtils.isNotBlank(key) && value != null) {
                    params.put(key, value);
                }
            }
        } catch (Exception e) {
            log.error("获取接口参数失败: {}", e.getMessage());
        }

        return params;
    }

    /**
     * 根据wbjkid获取交易类型信息
     * @param wbjkid 外部接口ID
     * @return 交易类型列表
     */
    protected List<IiTradetypeinfo> getTradeTypeInfo(String wbjkid) {
        try {
            return tradeTypeInfoService.selectList(IiTradetypeinfo.builder().wbjkid(wbjkid).build());
        } catch (Exception e) {
            log.error("获取交易类型信息失败: {}", e.getMessage());
            return new ArrayList<>();
        }
    }

    /**
     * 执行SQL查询
     * @param sqlId SQL ID
     * @return 查询结果
     */
    protected List<Map<String, Object>> executeSql(String sqlId) {
        List<Map<String, Object>> result = new ArrayList<>();

        try {
            // 从gi_dbddldefine表中获取SQL定义
            GiDbddldefine sqlDefine = defineService.selectOneByKey(sqlId);

            if (sqlDefine != null && StringUtils.isNotBlank(sqlDefine.getXtsqly())) {
                String sql = sqlDefine.getXtsqly();
                result = jdbcTemplate.queryForList(sql);
            }
        } catch (Exception e) {
            log.error("执行SQL查询失败: {}", e.getMessage());
        }

        return result;
    }

    /**
     * 处理单个交易类型
     * @param tradeType 交易类型信息
     * @param commonParams 公共参数
     */
    protected void processTradeType(IiTradetypeinfo tradeType, Map<String, Object> commonParams) {
        if (tradeType == null || tradeType.getJyrkly() == null) {
            log.warn("交易类型信息不完整，跳过处理");
            return;
        }

        String sqlId = tradeType.getJyrkly().toString();

        // 执行SQL获取数据
        List<Map<String, Object>> dataList = executeSql(sqlId);

        if (dataList.isEmpty()) {
            log.info("未查询到待处理数据");
            return;
        }

        // 处理每条数据
        for (Map<String, Object> data : dataList) {
            // 合并公共参数和数据参数
            Map<String, Object> processData = new HashMap<>(commonParams);
            processData.putAll(data);

            // 交易前处理
            Map<String, Object> preProcessedData = preTransaction(processData);

            // 交易处理
            Map<String, Object> transactionResult = transaction(preProcessedData);

            // 交易后处理
            boolean postProcessSuccess = postTransaction(processData, transactionResult);

            // 记录日志
            if (postProcessSuccess) {
                logTransaction(processData, transactionResult);
            }
        }
    }

    /**
     * 处理所有交易类型
     * @param wbjkid 外部接口ID
     */
    public void processAllTradeTypes(String wbjkid) {
        // 获取公共参数
        Map<String, Object> commonParams = getInterParams(wbjkid);
        commonParams.put("WBJKID", wbjkid);

        // 设置参数
        setParams(commonParams);

        // 获取交易类型信息
        List<IiTradetypeinfo> tradeTypes = getTradeTypeInfo(wbjkid);

        if (tradeTypes.isEmpty()) {
            log.info("未找到交易类型信息: WBJKID={}", wbjkid);
            return;
        }

        // 处理每个交易类型
        for (IiTradetypeinfo tradeType : tradeTypes) {
            log.info("开始处理交易类型: {}", tradeType.getJylxmc());
            processTradeType(tradeType, commonParams);
        }
    }
}
