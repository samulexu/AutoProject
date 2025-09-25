package com.etrackhis.autoproject.domain;

import java.util.Date;
import java.io.Serial;
import com.tocloud.common.core.domain.BaseEntity;
import com.tocloud.common.core.annotation.TcColumn;
import com.tocloud.common.core.annotation.TcTable;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

/**
 * (GiDataformatdefine)实体类
 *
 * @author Xuwq
 * @since 2025-09-25 17:41:09
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Tag(name="GiDataformatdefine", description="GiDataformatdefine对象")
@TcTable(name ="GI_DATAFORMATDEFINE", description="GiDataformatdefine对象")
public class GiDataformatdefine extends BaseEntity {
    @Serial
    private static final long serialVersionUID = 1L;
        @Schema(description = "sjgsid")
        @TcColumn(name="sjgsid", isPrimaryKey = true, required = true )
    private String sjgsid;

        @Schema(description = "xtmklx")
        @TcColumn(name="xtmklx")
    private String xtmklx;

        @Schema(description = "sjgdmc")
        @TcColumn(name="sjgdmc")
    private String sjgdmc;

        @Schema(description = "sjgslx")
        @TcColumn(name="sjgslx")
    private String sjgslx;

        @Schema(description = "sjjddm")
        @TcColumn(name="sjjddm")
    private String sjjddm;

        @Schema(description = "xgczsj")
        @TcColumn(name="xgczsj")
    private Date xgczsj;

        @Schema(description = "xgyhdm")
        @TcColumn(name="xgyhdm")
    private String xgyhdm;

    /**
     * 获取主键拼接值
     */
    @Override
    public String getPkCode() { 
        return this.sjgsid;
    }
}
