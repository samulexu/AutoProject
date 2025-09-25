package com.etrackhis.autoproject.mapper.fixed;

import com.etrack.common.core.mapper.BaseMapper;
import com.etrackhis.autoproject.domain.GiDbddldefine;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
 

@Mapper
public interface GiDbddldefineMapper extends BaseMapper<GiDbddldefine> {
    GiDbddldefine selectOneByKey(@Param("xtsqld") String xtsqld);
}

