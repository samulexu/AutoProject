package com.etrackhis.autoproject.mapper.fixed;

import com.tocloud.framework.mapper.BaseMapper;
import com.etrackhis.autoproject.domain.AiInterparm;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
 
/**
 * (AiInterparm)数据层
 *
 * @author Xuwq
 * @since 2025-09-25 17:40:15
 */
@Mapper
public interface AiInterparmMapper extends BaseMapper<AiInterparm> {
    AiInterparm selectOneByKey(@Param("wbjkid") String wbjkid, @Param("jkcsxh") Integer jkcsxh);
}

