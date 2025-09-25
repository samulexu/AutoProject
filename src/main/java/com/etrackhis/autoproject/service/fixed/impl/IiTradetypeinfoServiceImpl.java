package com.etrackhis.autoproject.service.fixed.impl;

import com.etrack.common.core.mapper.BaseMapper;
import com.etrack.common.core.service.BaseServiceImpl;
import com.etrackhis.autoproject.domain.IiTradetypeinfo;
import com.etrackhis.autoproject.mapper.fixed.IiTradetypeinfoMapper;
import com.etrackhis.autoproject.service.fixed.IIiTradetypeinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class IiTradetypeinfoServiceImpl extends BaseServiceImpl<IiTradetypeinfo> implements IIiTradetypeinfoService {
    @Autowired
    IiTradetypeinfoMapper baseMapper;

    @Override
    public BaseMapper<IiTradetypeinfo> getBaseMapper() {
        return baseMapper;
    }
    
    @Override
    public IiTradetypeinfo selectOneByKey(String jylxid){;
        return baseMapper.selectOneByKey(jylxid);
    }
}
