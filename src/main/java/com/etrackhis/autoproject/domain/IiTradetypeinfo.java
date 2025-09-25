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
 * 交易类型信息II_TRADETYPEINFO(IiTradetypeinfo)实体类
 *
 * @author Xuwq
 * @since 2025-09-25 17:41:53
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Tag(name="交易类型信息IITRADETYPEINFO", description="交易类型信息IITRADETYPEINFO对象")
@TcTable(name ="II_TRADETYPEINFO", description="交易类型信息IITRADETYPEINFO对象")
public class IiTradetypeinfo extends BaseEntity {
    @Serial
    private static final long serialVersionUID = 1L;
    /**
     * 接口类型编码
     */
        @Schema(description = "接口类型编码")
        @TcColumn(name="jylxid", isPrimaryKey = true, required = true )
    private String jylxid;

    /**
     * 外部接口序号
     */
        @Schema(description = "外部接口序号")
        @TcColumn(name="wbjkid")
    private String wbjkid;

    /**
     * 组织机构代码
     */
        @Schema(description = "组织机构代码")
        @TcColumn(name="zzjgdm")
    private String zzjgdm;

    /**
     * 接口类型编码
     */
        @Schema(description = "接口类型编码")
        @TcColumn(name="jylxbm")
    private String jylxbm;

    /**
     * 交易类型名称
     */
        @Schema(description = "交易类型名称")
        @TcColumn(name="jylxmc")
    private String jylxmc;

    /**
     * 接口交易表名
     */
        @Schema(description = "接口交易表名")
        @TcColumn(name="jkjybm")
    private String jkjybm;

    /**
     * 交易入口来源
     */
        @Schema(description = "交易入口来源")
        @TcColumn(name="jyrkly")
    private String jyrkly;

    /**
     * 交易参数来源
     */
        @Schema(description = "交易参数来源")
        @TcColumn(name="jycsly")
    private String jycsly;

    /**
     * 交易处理来源
     */
        @Schema(description = "交易处理来源")
        @TcColumn(name="jyclly")
    private String jyclly;

    /**
     * 最后数据编号
     */
        @Schema(description = "最后数据编号")
        @TcColumn(name="zhsjid")
    private String zhsjid;

    /**
     * 修改用户代码
     */
        @Schema(description = "修改用户代码")
        @TcColumn(name="xgyhdm")
    private String xgyhdm;

    /**
     * 修改操作时间
     */
        @Schema(description = "修改操作时间")
        @TcColumn(name="xgczsj")
    private Date xgczsj;

    /**
     * 获取主键拼接值
     */
    @Override
    public String getPkCode() { 
        return this.jylxid;
    }
}
