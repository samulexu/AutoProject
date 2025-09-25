package com.etrackhis.autoproject.domain;

import com.etrack.common.core.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IiTradetypeinfo extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 接口类型编码
     */
    private String jylxid;

    /**
     * 外部接口序号
     */
    private String wbjkid;

    /**
     * 组织机构代码
     */
    private String zzjgdm;

    /**
     * 接口类型编码
     */
    private String jylxbm;

    /**
     * 交易类型名称
     */
    private String jylxmc;

    /**
     * 接口交易表名
     */
    private String jkjybm;

    /**
     * 交易入口来源
     */
    private String jyrkly;

    /**
     * 交易参数来源
     */
    private String jycsly;

    /**
     * 交易处理来源
     */
    private String jyclly;

    /**
     * 最后数据编号
     */
    private String zhsjid;

    /**
     * 修改用户代码
     */
    private String xgyhdm;

    /**
     * 修改操作时间
     */
    private Date xgczsj;

    /**
     * 获取主键拼接值
     */
    public String getPkCode() {
        return this.jylxid;
    }
}
