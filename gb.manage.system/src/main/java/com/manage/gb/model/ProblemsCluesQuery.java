package com.manage.gb.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 线索征集表
 * </p>
 *
 * @author zxd
 * @since 2020-12-16
 */
@Data
public class ProblemsCluesQuery extends Page<ProblemsClues> implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    /**
     * 主体名称
     */
    private String subjectName;

    /**
     * 问题内容
     */
    private String content;

    /**
     * 状态	1.已提交2.已收集3.已下发
     */
    private Integer status;

    /**
     * 选登状态	1. 被选登 2.未被选登
     */
    private Integer seleStatus;

    private Integer collectStatus;

    private Integer publicStatus;

    /**
     * 标题
     */
    private String title;

    /**
     * 统一社会信用代码
     */
    private String uniscid;

    /**
     * 企业/机构属地
     */
    private String orgTerritorial;

    /**
     * 提交人身份证
     */
    private String committerIdcard;

    /**
     * 提交人姓名
     */
    private String committerName;

    /**
     * 提交人手机号码
     */
    private String committerPhonenum;

    /**
     * 提交人性别
     */
    private Boolean committerSex;

    /**
     * 是否允许公开	0.不允许1.允许
     */
    private Boolean showPublic;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 创建人
     */
    private Long createBy;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 更新人
     */
    private Long updateBy;

    /**
     * 删除标记	0.未删除1.已删除
     */
    private Boolean deleteFlag;

}
