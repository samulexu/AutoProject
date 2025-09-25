package com.etrackhis.autoproject.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;


@Component
@Scope("singleton")
public class SpringContextUtils implements ApplicationContextAware {

    private static ApplicationContext applicationContext;
    private static ConcurrentHashMap global = new ConcurrentHashMap<String,Object>();

    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        SpringContextUtils.applicationContext = applicationContext;
    }

    public void setGlobal(String key,Object value){
        global.put(key, value);
    }
    public Object getGlobal(String key){
        return global.get(key);
    }

    public Object globalContain(String key){
        if (global.containsKey(key)){
            return global.get(key);
        }else {return null;}
    }
    public Object globalContain(String key,Object value){
        if (global.containsKey(key) && value.equals(global.get(key))){
            return global.get(key);
        }else {return null;}
    }

    public static Object getBean(String name) {
        return applicationContext.getBean(name);
    }

    public static <T> T getBean(Class<T> requiredType) {
        return applicationContext.getBean(requiredType);
    }

    public static <T> T getBean(String name, Class<T> requiredType) {
        return applicationContext.getBean(name, requiredType);
    }

    public static ApplicationContext getContext(){
        return applicationContext;
    }

    public static boolean containsBean(String name) {
        return applicationContext.containsBean(name);
    }

    public static boolean isSingleton(String name) {
        return applicationContext.isSingleton(name);
    }

    public static Class<? extends Object> getType(String name) {
        return applicationContext.getType(name);
    }
}
