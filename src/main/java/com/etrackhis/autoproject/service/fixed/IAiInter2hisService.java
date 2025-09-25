package com.etrackhis.autoproject.service.fixed;

import com.etrack.common.core.service.IBaseService;
import com.etrackhis.autoproject.domain.AiInter2his;


public interface IAiInter2hisService extends IBaseService<AiInter2his> {
    public AiInter2his selectOneByKey(Long jkdzid);
}
