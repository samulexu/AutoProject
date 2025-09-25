package com.etrackhis.autoproject.service.fixed.impl;

import com.etrack.common.core.mapper.BaseMapper;
import com.etrack.common.core.service.BaseServiceImpl;
import com.etrackhis.autoproject.domain.AiInter2his;
import com.etrackhis.autoproject.mapper.fixed.AiInter2hisMapper;
import com.etrackhis.autoproject.service.fixed.IAiInter2hisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AiInter2hisServiceImpl extends BaseServiceImpl<AiInter2his> implements IAiInter2hisService {
    @Autowired
    AiInter2hisMapper baseMapper;

    @Override
    public BaseMapper<AiInter2his> getBaseMapper() {
        return baseMapper;
    }
    
    @Override
    public AiInter2his selectOneByKey(Long jkdzid){;
        return baseMapper.selectOneByKey(jkdzid);
    }
}
