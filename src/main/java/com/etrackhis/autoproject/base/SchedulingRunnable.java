package com.etrackhis.autoproject.base;

import com.etrackhis.autoproject.service.AutoInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;
import java.util.Map;

@Slf4j
public class SchedulingRunnable implements Runnable, ApplicationContextAware {

    private static ApplicationContext applicationContext;
    private final String beanName; // 对应YWJKDX的bean名称
    private final Map<String, Object> params; // 接口参数

    public SchedulingRunnable(String beanName, Map<String, Object> params) {
        this.beanName = beanName;
        this.params = params;
    }

    @Override
    public void run() {
        log.info("===== 开始执行定时任务 [{}] =====", beanName);
        try {
            // 获取服务实例（必须实现AutoInterface）
            AutoInterface service = (AutoInterface) applicationContext.getBean(beanName);
            if (service == null) {
                log.error("未找到服务实例: {}", beanName);
                return;
            }

            // 1. 初始化
            boolean initSuccess = service.init();
            if (!initSuccess) {
                log.error("服务[{}]初始化失败", beanName);
                return;
            }

            // 2. 设置参数（调用AutoBaseService的setParams方法）
            setServiceParams(service, params);

            // 3. 执行核心服务
            service.service();

            // 4. 服务后处理
            service.afterService();

            // 5. 状态检查
            Map<String, Object> checkResult = service.chek();
            log.info("服务[{}]执行状态: {}", beanName, checkResult);

        } catch (Exception e) {
            log.error("定时任务[{}]执行失败", beanName, e);
        } finally {
            log.info("===== 定时任务 [{}] 执行结束 =====", beanName);
        }
    }

    /**
     * 设置服务参数（调用AutoBaseService的setParams方法）
     */
    private void setServiceParams(AutoInterface service, Map<String, Object> params) {
        try {
            // 尝试调用自身setParams方法
            Method setParamsMethod = service.getClass().getDeclaredMethod("setParams", Map.class);
            ReflectionUtils.makeAccessible(setParamsMethod);
            setParamsMethod.invoke(service, params);
            log.info("服务[{}]参数设置完成", beanName);
        } catch (NoSuchMethodException e) {
            log.debug("服务[{}]自身无setParams方法，尝试父类", beanName);
            // 尝试调用父类（AutoBaseService）的setParams方法
            try {
                Method setParamsMethod = service.getClass().getSuperclass().getDeclaredMethod("setParams", Map.class);
                ReflectionUtils.makeAccessible(setParamsMethod);
                setParamsMethod.invoke(service, params);
                log.info("服务[{}]父类参数设置完成", beanName);
            } catch (Exception e1) {
                log.warn("服务[{}]未实现参数设置方法，跳过参数注入", beanName);
            }
        } catch (Exception e) {
            log.error("服务[{}]参数设置失败", beanName, e);
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        applicationContext = context;
    }
}