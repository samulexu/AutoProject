package com.etrackhis.autoproject.service.fixed.impl;

import com.etrack.common.core.mapper.BaseMapper;
import com.etrack.common.core.service.BaseServiceImpl;
import com.etrackhis.autoproject.domain.AiInterparm;
import com.etrackhis.autoproject.mapper.fixed.AiInterparmMapper;
import com.etrackhis.autoproject.service.fixed.IAiInterparmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AiInterparmServiceImpl extends BaseServiceImpl<AiInterparm> implements IAiInterparmService {
    @Autowired
    AiInterparmMapper baseMapper;

    @Override
    public BaseMapper<AiInterparm> getBaseMapper() {
        return baseMapper;
    }
    
    @Override
    public AiInterparm selectOneByKey(String wbjkid,Integer jkcsxh){;
        return baseMapper.selectOneByKey(wbjkid,jkcsxh);
    }
}
