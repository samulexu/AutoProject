package com.etrackhis.autoproject.service.fixed;

import com.etrackhis.autoproject.domain.AiInterparm;
import com.etrackhis.autoproject.mapper.fixed.AiInterparmMapper;
import com.tocloud.framework.service.IBaseService;

/**
 * (AiInterparm)表服务接口
 *
 * @author Xuwq
 * @since 2025-09-25 17:40:15
 */
public interface IAiInterparmService extends IBaseService<AiInterparmMapper, AiInterparm> {
    default AiInterparm selectOneByKey(String wbjkid, Integer jkcsxh) {
        return getBaseMapper().selectOneByKey(wbjkid, jkcsxh);
    };
}
