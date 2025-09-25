package com.etrackhis.autoproject.service.fixed;

import com.etrack.common.core.service.IBaseService;
import com.etrackhis.autoproject.domain.AiInterparm;


public interface IAiInterparmService extends IBaseService<AiInterparm> {
    public AiInterparm selectOneByKey(String wbjkid,Integer jkcsxh);
}
