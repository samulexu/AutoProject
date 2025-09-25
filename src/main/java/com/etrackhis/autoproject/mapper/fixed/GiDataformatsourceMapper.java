package com.etrackhis.autoproject.mapper.fixed;

import com.tocloud.framework.mapper.BaseMapper;
import com.etrackhis.autoproject.domain.GiDataformatsource;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
 
/**
 * 数据格式来源(GiDataformatsource)数据层
 *
 * @author Xuwq
 * @since 2025-09-25 17:41:23
 */
@Mapper
public interface GiDataformatsourceMapper extends BaseMapper<GiDataformatsource> {
    GiDataformatsource selectOneByKey(@Param("sjgsid") String sjgsid, @Param("sjlyxh") Integer sjlyxh);
}

