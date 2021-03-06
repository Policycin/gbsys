package com.manage.gb.model;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * <p>
 * 线索征集表
 * </p>
 *
 * @author zxd
 * @since 2020-12-16
 */
@TableName("problems_clues")
public class ProblemsClues implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
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
     * 提交状态
     */
    private Integer status;

    private Integer collectStatus;

    private Integer publicStatus;

    /**
     * 选登状态	1. 被选登 2.未被选登
     */
    private Integer seleStatus;

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

    private LocalDateTime collectTime;

    private LocalDateTime publicTime;

    private LocalDateTime seleTime;

    public LocalDateTime getSeleTime() {
        return seleTime;
    }

    public void setSeleTime(LocalDateTime seleTime) {
        this.seleTime = seleTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSeleStatus() {
        return seleStatus;
    }

    public void setSeleStatus(Integer seleStatus) {
        this.seleStatus = seleStatus;
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

    public LocalDateTime getCollectTime() {
        return collectTime;
    }

    public void setCollectTime(LocalDateTime collectTime) {
        this.collectTime = collectTime;
    }

    public LocalDateTime getPublicTime() {
        return publicTime;
    }

    public void setPublicTime(LocalDateTime publicTime) {
        this.publicTime = publicTime;
    }

    public Integer getCollectStatus() {
        return collectStatus;
    }

    public void setCollectStatus(Integer collectStatus) {
        this.collectStatus = collectStatus;
    }

    public Integer getPublicStatus() {
        return publicStatus;
    }

    public void setPublicStatus(Integer publicStatus) {
        this.publicStatus = publicStatus;
    }


}
