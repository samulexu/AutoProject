package com.etrackhis.autoproject.service;

import java.util.Map;


public interface AutoInterface {
    /**
     * 初始化
     * @return
     */
    boolean init();
    /**
     * 服务启动
     * @return
     */
    boolean service();
    /**
     * 服务结束之后
     * @return
     */
    boolean afterService();
    /**
     * 服务检查信息返回
     * @return
     */
    Map chek();

    /**
     * 接口交易处理
     */
    Map interTransaction(Map map);





}
