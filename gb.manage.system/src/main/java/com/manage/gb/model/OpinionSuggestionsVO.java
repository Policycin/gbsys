package com.manage.gb.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 意见建议表
 * </p>
 *
 * @author zxd
 * @since 2020-12-16
 */
@Data
public class OpinionSuggestionsVO implements Serializable {

    private static final long serialVersionUID=1L;


    /**
     * 执法部门名称
     */
    private String staffName;

    /**
     * 问题内容
     */
    private String content;


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
     * 是否匿名	0.匿名 1.实名
     */
    private Boolean hideShow;


}
