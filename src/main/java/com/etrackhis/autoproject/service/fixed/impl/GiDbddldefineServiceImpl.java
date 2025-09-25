package com.etrackhis.autoproject.service.fixed.impl;

import com.etrack.common.core.mapper.BaseMapper;
import com.etrack.common.core.service.BaseServiceImpl;
import com.etrackhis.autoproject.domain.GiDbddldefine;
import com.etrackhis.autoproject.mapper.fixed.GiDbddldefineMapper;
import com.etrackhis.autoproject.service.fixed.IGiDbddldefineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class GiDbddldefineServiceImpl extends BaseServiceImpl<GiDbddldefine> implements IGiDbddldefineService {
    @Autowired
    GiDbddldefineMapper baseMapper;

    @Override
    public BaseMapper<GiDbddldefine> getBaseMapper() {
        return baseMapper;
    }
    
    @Override
    public GiDbddldefine selectOneByKey(String xtsqld){;
        return baseMapper.selectOneByKey(xtsqld);
    }
}
