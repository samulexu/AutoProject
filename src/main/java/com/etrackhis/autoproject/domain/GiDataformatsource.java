package com.etrackhis.autoproject.domain;

import java.io.Serial;
import com.tocloud.common.core.domain.BaseEntity;
import com.tocloud.common.core.annotation.TcColumn;
import com.tocloud.common.core.annotation.TcTable;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

/**
 * 数据格式来源(GiDataformatsource)实体类
 *
 * @author Xuwq
 * @since 2025-09-25 17:41:23
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Tag(name="数据格式来源", description="数据格式来源对象")
@TcTable(name ="GI_DATAFORMATSOURCE", description="数据格式来源对象")
public class GiDataformatsource extends BaseEntity {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 数据格式编码SJGSID
     */
        @Schema(description = "数据格式编码")
        @TcColumn(name="sjgsid", isPrimaryKey = true, required = true )
    private String sjgsid;

    /**
     * 数据来源序号SJLYXH
     */
        @Schema(description = "数据来源序号")
        @TcColumn(name="sjlyxh", isPrimaryKey = true, required = true )
    private Integer sjlyxh;

    /**
     * 父类来源序号FLLYXH
     */
        @Schema(description = "父类来源序号")
        @TcColumn(name="fllyxh")
    private Integer fllyxh;

    /**
     * 数据节点代码SJJDDM
     */
        @Schema(description = "数据节点代码")
        @TcColumn(name="sjjddm")
    private String sjjddm;

    /**
     * 数据来源内容SJLYNR
     */
        @Schema(description = "数据来源内容")
        @TcColumn(name="sjlynr")
    private String sjlynr;

    /**
     * 系统连接序号XTDBDM
     */
        @Schema(description = "系统连接序号")
        @TcColumn(name="xtdbdm")
    private String xtdbdm;

    /**
     * 排斥来源序号PCLYXH
     */
        @Schema(description = "排斥来源序号")
        @TcColumn(name="pclyxh")
    private Integer pclyxh;

    /**
     * 数据节点类别SJJDLB
     */
        @Schema(description = "数据节点类别")
        @TcColumn(name="sjjdlb")
    private String sjjdlb;

    /**
     * 父类关联字段FLGLZD
     */
        @Schema(description = "父类关联字段")
        @TcColumn(name="flglzd")
    private String flglzd;

    /**
     * 获取主键拼接值
     */
    @Override
    public String getPkCode() { 
        return this.sjgsid+"_"+this.sjlyxh;
    }
}
