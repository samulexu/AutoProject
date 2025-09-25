package com.etrackhis.autoproject.service.fixed;

import com.etrackhis.autoproject.domain.IiTradetypeinfo;
import com.etrackhis.autoproject.mapper.fixed.IiTradetypeinfoMapper;
import com.tocloud.framework.service.IBaseService;

/**
 * 交易类型信息II_TRADETYPEINFO(IiTradetypeinfo)表服务接口
 *
 * @author Xuwq
 * @since 2025-09-25 17:41:53
 */
public interface IIiTradetypeinfoService extends IBaseService<IiTradetypeinfoMapper, IiTradetypeinfo> {
    default IiTradetypeinfo selectOneByKey(String jylxid) {
        return getBaseMapper().selectOneByKey(jylxid);
    };
}
