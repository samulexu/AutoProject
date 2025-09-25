package com.etrackhis.autoproject.service.fixed;

import com.etrackhis.autoproject.domain.GiDataformatsource;
import com.etrackhis.autoproject.mapper.fixed.GiDataformatsourceMapper;
import com.tocloud.framework.service.IBaseService;

/**
 * 数据格式来源(GiDataformatsource)表服务接口
 *
 * @author Xuwq
 * @since 2025-09-25 17:41:23
 */
public interface IGiDataformatsourceService extends IBaseService<GiDataformatsourceMapper, GiDataformatsource> {
    default GiDataformatsource selectOneByKey(String sjgsid, Integer sjlyxh) {
        return getBaseMapper().selectOneByKey(sjgsid, sjlyxh);
    };
}
