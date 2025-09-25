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
public class GiDbddldefine extends BaseEntity {
    private static final long serialVersionUID = 1L;

    
    private String xtsqld;

    
    private String xtsqlm;

    
    private String xtdbdm;

    
    private String xtmklx;

    
    private String sqlylx;

    
    private String xtsqly;

    
    private Date xgczsj;

    
    private String xgyhdm;

    /**
     * 获取主键拼接值
     */
    public String getPkCode() {
        return this.xtsqld;
    }
}
