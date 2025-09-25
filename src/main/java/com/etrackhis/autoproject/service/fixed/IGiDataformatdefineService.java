package com.etrackhis.autoproject.service.fixed;

import com.etrackhis.autoproject.domain.GiDataformatdefine;
import com.etrackhis.autoproject.mapper.fixed.GiDataformatdefineMapper;
import com.tocloud.framework.service.IBaseService;

/**
 * (GiDataformatdefine)表服务接口
 *
 * @author Xuwq
 * @since 2025-09-25 17:41:09
 */
public interface IGiDataformatdefineService extends IBaseService<GiDataformatdefineMapper, GiDataformatdefine> {
    default GiDataformatdefine selectOneByKey(String sjgsid) {
        return getBaseMapper().selectOneByKey(sjgsid);
    };
}
