package com.etrackhis.autoproject.mapper.fixed;

import com.etrack.common.core.mapper.BaseMapper;
import com.etrackhis.autoproject.domain.AiInter2his;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
 

@Mapper
public interface AiInter2hisMapper extends BaseMapper<AiInter2his> {
    AiInter2his selectOneByKey(@Param("jkdzid") Long jkdzid);
}

