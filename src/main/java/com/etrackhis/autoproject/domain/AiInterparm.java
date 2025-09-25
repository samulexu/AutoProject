package com.etrackhis.autoproject.domain;

import java.io.Serial;
import com.tocloud.common.core.domain.BaseEntity;
import com.tocloud.common.core.annotation.TcColumn;
import com.tocloud.common.core.annotation.TcTable;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

/**
 * (AiInterparm)实体类
 *
 * @author Xuwq
 * @since 2025-09-25 17:40:15
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Tag(name="AiInterparm", description="AiInterparm对象")
@TcTable(name ="AI_INTERPARM", description="AiInterparm对象")
public class AiInterparm extends BaseEntity {
    @Serial
    private static final long serialVersionUID = 1L;

        @Schema(description = "wbjkid")
        @TcColumn(name="wbjkid", isPrimaryKey = true, required = true )
    private String wbjkid;

        @Schema(description = "jkcsxh")
        @TcColumn(name="jkcsxh", isPrimaryKey = true, required = true )
    private Integer jkcsxh;

        @Schema(description = "jkcsyw")
        @TcColumn(name="jkcsyw")
    private String jkcsyw;

        @Schema(description = "jkcszw")
        @TcColumn(name="jkcszw")
    private String jkcszw;

        @Schema(description = "jkcsnr")
        @TcColumn(name="jkcsnr")
    private String jkcsnr;

        @Schema(description = "jkcssm")
        @TcColumn(name="jkcssm")
    private String jkcssm;

    /**
     * 获取主键拼接值
     */
    @Override
    public String getPkCode() { 
        return this.wbjkid+"_"+this.jkcsxh;
    }
}
