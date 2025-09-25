package com.etrackhis.autoproject.base;

import com.etrack.common.core.utils.MapUtils;
import com.etrackhis.autoproject.service.AutoBaseService;
import com.etrackhis.autoproject.utils.SpringContextUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;


@Slf4j
public class SchedulingRunnable implements Runnable {

    private String beanName;
    private String methodName;

    // 任务执行队列：交易前处理、交易处理、交易后处理
    private final String[] runQueue = {"preTransaction", "transaction", "postTransaction"};

    private Class service;
    private Object serviceInstance;
    private Class superService;
    private Object superServiceInstance;
    private String wbjkid;

    /**
     * 构造函数
     * @param beanName Bean名称
     * @param params 参数
     */
    public SchedulingRunnable(String beanName, Map<String, Object> params) {
        this.beanName = beanName;
        Map<String, Object> taskParams = new HashMap<>(params);
        wbjkid = MapUtils.getString(taskParams, "WBJKID", "");

        try {
            // 获取服务实例
            if (SpringContextUtils.containsBean(StringUtils.uncapitalize(beanName))) {
                serviceInstance = SpringContextUtils.getBean(StringUtils.uncapitalize(beanName));
            } else if (SpringContextUtils.containsBean(beanName)) {
                serviceInstance = SpringContextUtils.getBean(beanName);
            }

            if (serviceInstance == null) {
                log.error("无法找到对应的BEAN：{}", beanName);
                return;
            }

            service = serviceInstance.getClass();
            superService = service.getSuperclass();

            // 设置参数
            setServiceParams(taskParams);

        } catch (Exception e) {
            log.error("任务准备失败，错误信息：{}", e.getMessage());
        }
    }

    /**
     * 设置服务参数
     * @param params 参数
     */
    private void setServiceParams(Map<String, Object> params) {
        try {
            Method setParamsMethod = service.getDeclaredMethod("setParams", Map.class);
            ReflectionUtils.makeAccessible(setParamsMethod);
            setParamsMethod.invoke(serviceInstance, params);
        } catch (NoSuchMethodException e) {
            try {
                Method setParamsMethod = superService.getDeclaredMethod("setParams", Map.class);
                ReflectionUtils.makeAccessible(setParamsMethod);
                setParamsMethod.invoke(serviceInstance, params);
            } catch (NoSuchMethodException e1) {
                // 如果没有setParams方法，跳过参数设置
                log.debug("服务{}未设置参数方法setParams", beanName);
            } catch (Exception e2) {
                log.error("设置参数失败：{}", e2.getMessage());
            }
        } catch (Exception e) {
            log.error("设置参数失败：{}", e.getMessage());
        }
    }

    @Override
    public void run() {
        if (serviceInstance == null) {
            log.error("服务实例未初始化，任务不执行");
            return;
        }

        long startTime = System.currentTimeMillis();
        log.info("任务开始计时[{}]", startTime);

        try {
            // 如果服务是AutoService类型，直接调用processAllTradeTypes方法
            if (serviceInstance instanceof AutoBaseService) {
                AutoBaseService autoService = (AutoBaseService) serviceInstance;
                if (StringUtils.isNotBlank(wbjkid)) {
                    autoService.processAllTradeTypes(wbjkid);
                } else {
                    log.error("WBJKID为空，无法执行任务");
                }
            } else {
                // 按顺序执行任务队列中的方法
                executeTaskQueue();
            }
        } catch (Exception ex) {
            log.error(String.format("定时任务执行异常 - bean：%s，方法：%s", beanName, methodName), ex);
        }

        long times = System.currentTimeMillis() - startTime;
        log.info("任务结束计时[{}]任务耗时：[{}] 毫秒", System.currentTimeMillis(), times);
    }

    /**
     * 执行任务队列
     */
    private void executeTaskQueue() {
        boolean continueExecution = true;

        for (String methodName : runQueue) {
            this.methodName = methodName;
            log.info("定时任务开始执行 - bean：{}，方法：{}", beanName, methodName);

            // 执行方法
            try {
                continueExecution = executeMethod(methodName);
            } catch (Exception e) {
                log.error("执行方法{}失败：{}", methodName, e.getMessage());
                continueExecution = false;
            }

            // 如果某个方法返回false，中断后续执行
            if (!continueExecution) {
                log.info("任务执行中断于方法：{}", methodName);
                break;
            }
        }
    }

    /**
     * 执行指定方法
     * @param methodName 方法名
     * @return 执行结果
     * @throws Exception 异常
     */
    private boolean executeMethod(String methodName) throws Exception {
        try {
            Method method = service.getDeclaredMethod(methodName);
            ReflectionUtils.makeAccessible(method);
            return (Boolean) method.invoke(serviceInstance);
        } catch (NoSuchMethodException e) {
            try {
                Method method = superService.getDeclaredMethod(methodName);
                ReflectionUtils.makeAccessible(method);
                return (Boolean) method.invoke(serviceInstance);
            } catch (NoSuchMethodException e1) {
                log.warn("服务{}未设置方法{}", beanName, methodName);
                // 如果方法不存在，默认继续执行
                return true;
            }
        }
    }
}