package com.manage.gb.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 线索征集表
 * </p>
 *
 * @author zxd
 * @since 2020-12-15
 */
public class OpinionSuggestions implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 投诉类型	1.企业2.执法监管部门
     */
    private Boolean problemType;

    /**
     * 问题内容
     */
    private String content;

    /**
     * 状态	1.已提交2.已收集3.已下发
     */
    private Boolean status;

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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getProblemType() {
        return problemType;
    }

    public void setProblemType(Boolean problemType) {
        this.problemType = problemType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUniscid() {
        return uniscid;
    }

    public void setUniscid(String uniscid) {
        this.uniscid = uniscid;
    }

    public String getOrgTerritorial() {
        return orgTerritorial;
    }

    public void setOrgTerritorial(String orgTerritorial) {
        this.orgTerritorial = orgTerritorial;
    }

    public String getCommitterIdcard() {
        return committerIdcard;
    }

    public void setCommitterIdcard(String committerIdcard) {
        this.committerIdcard = committerIdcard;
    }

    public String getCommitterName() {
        return committerName;
    }

    public void setCommitterName(String committerName) {
        this.committerName = committerName;
    }

    public String getCommitterPhonenum() {
        return committerPhonenum;
    }

    public void setCommitterPhonenum(String committerPhonenum) {
        this.committerPhonenum = committerPhonenum;
    }

    public Boolean getCommitterSex() {
        return committerSex;
    }

    public void setCommitterSex(Boolean committerSex) {
        this.committerSex = committerSex;
    }

    public Boolean getShowPublic() {
        return showPublic;
    }

    public void setShowPublic(Boolean showPublic) {
        this.showPublic = showPublic;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    public Boolean getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    @Override
    public String toString() {
        return "OpinionSuggestions{" +
        "id=" + id +
        ", problemType=" + problemType +
        ", content=" + content +
        ", status=" + status +
        ", title=" + title +
        ", uniscid=" + uniscid +
        ", orgTerritorial=" + orgTerritorial +
        ", committerIdcard=" + committerIdcard +
        ", committerName=" + committerName +
        ", committerPhonenum=" + committerPhonenum +
        ", committerSex=" + committerSex +
        ", showPublic=" + showPublic +
        ", createTime=" + createTime +
        ", createBy=" + createBy +
        ", updateTime=" + updateTime +
        ", updateBy=" + updateBy +
        ", deleteFlag=" + deleteFlag +
        "}";
    }
}
