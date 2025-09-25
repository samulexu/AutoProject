package com.etrackhis.autoproject.domain;

import java.io.Serial;
import com.tocloud.common.core.domain.BaseEntity;
import com.tocloud.common.core.annotation.TcColumn;
import com.tocloud.common.core.annotation.TcTable;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

/**
 * 接口字典对照AI_INTER2HIS(AiInter2his)实体类
 *
 * @author Xuwq
 * @since 2025-09-25 17:47:05
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Tag(name="接口字典对照AIINTER2HIS", description="接口字典对照AIINTER2HIS对象")
@TcTable(name ="AI_INTER2HIS", description="接口字典对照AIINTER2HIS对象")
public class AiInter2his extends BaseEntity {
    @Serial
    private static final long serialVersionUID = 1L;
    /**
     * 接口对照序号
     */
        @Schema(description = "接口对照序号")
        @TcColumn(name="jkdzid", isPrimaryKey = true, required = true )
    private Long jkdzid;

    /**
     * 外部接口序号
     */
        @Schema(description = "外部接口序号")
        @TcColumn(name="wbjkid")
    private String wbjkid;

    /**
     * 目录类别序号
     */
        @Schema(description = "目录类别序号")
        @TcColumn(name="mllbid")
    private Long mllbid;

    /**
     * 接口字典序号
     */
        @Schema(description = "接口字典序号")
        @TcColumn(name="jkzdid")
    private String jkzdid;

    /**
     * 医院目录序号
     */
        @Schema(description = "医院目录序号")
        @TcColumn(name="yymlid")
    private String yymlid;

    /**
     * 获取主键拼接值
     */
    @Override
    public String getPkCode() { 
        return String.valueOf(this.jkdzid);
    }
}
