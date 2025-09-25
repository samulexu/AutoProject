package com.etrackhis.autoproject.mapper.fixed;

import com.etrack.common.core.mapper.BaseMapper;
import com.etrackhis.autoproject.domain.AiInterparm;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
 

@Mapper
public interface AiInterparmMapper extends BaseMapper<AiInterparm> {
    AiInterparm selectOneByKey(@Param("wbjkid") String wbjkid,@Param("jkcsxh") Integer jkcsxh);
}

