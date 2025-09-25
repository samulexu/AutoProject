package com.etrackhis.autoproject.base;

import com.etrackhis.autoproject.config.AutoTaskConfig;
import com.etrackhis.autoproject.domain.AiInterparm;
import com.etrackhis.autoproject.service.fixed.IAiInterparmService;
import com.etrackhis.autoproject.service.fixed.IIiTradetypeinfoService;
import com.tocloud.common.core.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Component
public class AutoJobRunner implements CommandLineRunner {

    @Autowired
    private CronTaskRegister cronTaskRegister;

    @Autowired
    private AutoTaskConfig autoTaskConfig;

    @Autowired
    private IAiInterparmService interParamService;

    @Autowired
    private IIiTradetypeinfoService tradeTypeInfoService;

    // 任务列表
    List<String> taskList = new ArrayList<>();

    // 监控线程
    Thread managerThread;

    @Override
    public void run(String... args) {
        // 初始加载定时任务
        log.info("SysJobRunner 动态加载自动任务开始");

        // 从配置文件加载任务
        loadConfigTasks();

        log.info("SysJobRunner 加载自动任务完成");
    }

    /**
     * 从配置文件加载任务
     */
    private void loadConfigTasks() {
        if (autoTaskConfig.getInterIdList() == null || autoTaskConfig.getInterIdList().isEmpty()) {
            log.info("未配置interId列表，跳过任务加载");
            return;
        }

        log.info("SysJobRunner 加载配置文件任务 " + autoTaskConfig.getInterIdList().size());

        for (String interId : autoTaskConfig.getInterIdList()) {
            if (!taskList.contains(interId)) {
                taskList.add(interId);
                loadSingleConfigTask(interId);
            }
        }
    }

    /**
     * 加载单个配置文件任务
     * @param interId 外部接口ID
     */
    private void loadSingleConfigTask(String interId) {
        try {
            // 从本地配置中获取模块ID和Cron表达式
            String moduleId = getModuleIdFromDatabase(interId);
            String cronExpression = getCronFromDatabase(interId);

            if (StringUtils.isBlank(moduleId)) {
                log.error("未找到任务{}的模块配置", interId);
                return;
            }

            if (StringUtils.isBlank(cronExpression)) {
                log.error("未找到任务{}的Cron表达式配置", interId);
                return;
            }

            Map<String, Object> params = getCommonParams(interId);
            params.put("WBJKID", interId);

            // 创建并注册任务
            SchedulingRunnable task = new SchedulingRunnable(moduleId, params);
            cronTaskRegister.addCronTask(task, cronExpression);

            log.info("SysJobRunner 初始化任务 WBJKID: {}", interId);
        } catch (Exception e) {
            log.error("SysJobRunner 加载任务配置失败 - WBJKID: {}", interId, e);
        }
    }

    /**
     * 从数据库获取模块ID
     * @param interId 外部接口ID
     * @return 模块ID
     */
    private String getModuleIdFromDatabase(String interId) {
        // 从数据库获取模块ID，这里需要根据实际表结构实现
        // 示例代码，实际应根据数据库表结构修改
        try {
//            List<IiTradetypeinfo> tradeTypes = tradeTypeInfoService.selectList(IiTradetypeinfo.builder().interId(interId).build());
//            if (tradeTypes != null && !tradeTypes.isEmpty()) {
//                // 假设使用第一个交易类型的JYCSLY作为模块ID
//                Object jycsly = tradeTypes.get(0).getJycsly();
//                return jycsly != null ? jycsly.toString() : null;
//            }
        } catch (Exception e) {
            log.error("从数据库获取模块ID失败: {}", e.getMessage());
        }
        return null;
    }

    /**
     * 从数据库获取Cron表达式
     * @param interId 外部接口ID
     * @return Cron表达式
     */
    private String getCronFromDatabase(String interId) {
        // 从数据库获取Cron表达式，这里需要根据实际表结构实现
        // 示例代码，实际应根据数据库表结构修改
        try {
            List<AiInterparm> interParamList = interParamService.selectList(AiInterparm.builder().wbjkid(interId).build());
            for (AiInterparm param : interParamList) {
                if ("CRON_EXPRESSION".equals(param.getJkcsnr())) {
                    return param.getJkcsnr() != null ? param.getJkcsnr().toString() : null;
                }
            }
        } catch (Exception e) {
            log.error("从数据库获取Cron表达式失败: {}", e.getMessage());
        }
        return null;
    }

    /**
     * 获取公共参数
     * @param interId 外部接口ID
     * @return 参数Map
     */
    private Map<String, Object> getCommonParams(String interId) {
        Map<String, Object> params = new HashMap<>();

        try {
//            // 从ai_interparam表中获取参数
//            List<AiInterparm> interParams = interParamService.selectList(AiInterparm.builder().interId(interId).build());
//
//            for (AiInterparm param : interParams) {
//                String key = param.getJkcsyw() != null ? param.getJkcsyw().toString() : "";
//                Object value = param.getJkcsnr();
//
//                if (StringUtils.isNotBlank(key) && value != null && !"CRON_EXPRESSION".equals(key)) {
//                    params.put(key, value);
//                }
//            }
        } catch (Exception e) {
            log.error("获取公共参数失败: {}", e.getMessage());
        }

        return params;
    }
}