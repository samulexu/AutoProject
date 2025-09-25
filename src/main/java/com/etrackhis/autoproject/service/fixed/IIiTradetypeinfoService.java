package com.etrackhis.autoproject.service.fixed;

import com.etrack.common.core.service.IBaseService;
import com.etrackhis.autoproject.domain.IiTradetypeinfo;


public interface IIiTradetypeinfoService extends IBaseService<IiTradetypeinfo> {
    public IiTradetypeinfo selectOneByKey(String jylxid);
}
