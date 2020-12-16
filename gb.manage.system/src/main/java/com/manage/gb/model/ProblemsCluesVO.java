package com.manage.gb.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
public class ProblemsCluesVO implements Serializable {

    private static final long serialVersionUID=1L;


    /**
     * 主体名称
     */

    @NotNull(message = "主体名称不能为空")
    private String subjectName;

    /**
     * 问题内容
     */
    @NotNull(message = "主体名称不能为空")
    @Size(min = 20,max=200,message = "问题内容最少填写20个字符，最多填写200个字符")
    private String content;

    /**
     * 标题
     */
    @NotNull(message = "标题必须填写")
    private String title;

    /**
     * 统一社会信用代码
     */
    @NotNull(message = "统一社会信用代码必须填写")
    private String uniscid;

    /**
     * 企业/机构属地
     */
    @NotNull(message = "必须填写")
    private String orgTerritorial;

    /**
     * 提交人身份证
     */
    @NotNull(message = "提交人身份证必须填写")
    private String committerIdcard;

    /**
     * 提交人姓名
     */
    @NotNull(message = "提交人姓名必须填写")
    private String committerName;

    /**
     * 提交人手机号码
     */
    @NotNull(message = "提交人手机号码必须填写")
    private String committerPhonenum;

    /**
     * 提交人性别
     */
    @NotNull(message = "提交人性别必须填写")
    private Boolean committerSex;

    /**
     * 是否允许公开	0.不允许1.允许
     */
    private Boolean showPublic;


}
