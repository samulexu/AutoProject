package com.etrackhis.autoproject.domain;

import com.etrack.common.core.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AiInter2his extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 接口对照序号
     */
    private Long jkdzid;

    /**
     * 外部接口序号
     */
    private String wbjkid;

    /**
     * 目录类别序号
     */
    private Long mllbid;

    /**
     * 接口字典序号
     */
    private String jkzdid;

    /**
     * 医院目录序号
     */
    private String yymlid;

    /**
     * 获取主键拼接值
     */
    public Long getPkCode() {
        return this.jkdzid;
    }
}
