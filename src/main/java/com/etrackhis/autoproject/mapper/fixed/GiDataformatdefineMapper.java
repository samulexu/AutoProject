package com.etrackhis.autoproject.mapper.fixed;

import com.tocloud.framework.mapper.BaseMapper;
import com.etrackhis.autoproject.domain.GiDataformatdefine;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
 
/**
 * (GiDataformatdefine)数据层
 *
 * @author Xuwq
 * @since 2025-09-25 17:41:09
 */
@Mapper
public interface GiDataformatdefineMapper extends BaseMapper<GiDataformatdefine> {
    GiDataformatdefine selectOneByKey(@Param("sjgsid") String sjgsid);
}

