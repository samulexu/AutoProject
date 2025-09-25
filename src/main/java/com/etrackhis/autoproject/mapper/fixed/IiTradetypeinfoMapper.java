package com.etrackhis.autoproject.mapper.fixed;

import com.tocloud.framework.mapper.BaseMapper;
import com.etrackhis.autoproject.domain.IiTradetypeinfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
 
/**
 * 交易类型信息II_TRADETYPEINFO(IiTradetypeinfo)数据层
 *
 * @author Xuwq
 * @since 2025-09-25 17:41:53
 */
@Mapper
public interface IiTradetypeinfoMapper extends BaseMapper<IiTradetypeinfo> {
    IiTradetypeinfo selectOneByKey(@Param("jylxid") String jylxid);
}

