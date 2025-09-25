package com.etrackhis.autoproject.service.fixed;

import com.etrack.common.core.service.IBaseService;
import com.etrackhis.autoproject.domain.GiDbddldefine;


public interface IGiDbddldefineService extends IBaseService<GiDbddldefine> {
    public GiDbddldefine selectOneByKey(String xtsqld);
}
