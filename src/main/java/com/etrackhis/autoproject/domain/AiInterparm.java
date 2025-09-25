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
public class AiInterparm extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
      * 外部接口序号
      */
    private String wbjkid;
    /**
      * 接口参数序号
      */
    private Integer jkcsxh;

    /**
     * 接口参数英文
     */
    private String jkcsyw;

    /**
     * 接口参数中文
     */
    private String jkcszw;

    /**
     * 接口参数内容
     */
    private String jkcsnr;

    /**
     * 接口参数说明
     */
    private String jkcssm;

    /**
     * 获取主键拼接值
     */
    public String getPkCode() { 
        return this.wbjkid.toString()+"_"+this.jkcsxh.toString();
    }
}
