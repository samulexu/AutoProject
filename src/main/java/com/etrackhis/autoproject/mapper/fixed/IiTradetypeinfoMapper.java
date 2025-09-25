package com.etrackhis.autoproject.mapper.fixed;

import com.etrack.common.core.mapper.BaseMapper;
import com.etrackhis.autoproject.domain.IiTradetypeinfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
 

@Mapper
public interface IiTradetypeinfoMapper extends BaseMapper<IiTradetypeinfo> {
    IiTradetypeinfo selectOneByKey(@Param("jylxid") String jylxid);
}

