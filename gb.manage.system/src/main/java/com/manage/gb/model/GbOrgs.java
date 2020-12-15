package com.manage.gb.model;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 机构表 
 * </p>
 *
 * @author zxd
 * @since 2020-12-16
 */
public class GbOrgs implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "org_id", type = IdType.AUTO)
    private String orgId;

    private String orgCode;

    private String orgName;

    private String parentOrgId;

    private String orgType;

    private String regAddress;

    private LocalDateTime regDate;

    private LocalDate operEffDate;

    private LocalDate operExpDate;

    private String orgStatus;

    private String orgSeq;

    private LocalDateTime dataStamp;

    private String regionId;

    private String orgCcCode;

    private String extTag01;

    private String extTag02;

    private String extTag03;

    private String extTag04;

    private String extTag05;

    private String orgSname;

    private String orgVersion;

    private Boolean isPituitary;

    /**
     * 机构层级
     */
    private Boolean orgLvl;

    /**
     * 机构联系方式
     */
    private String orgPhone;

    /**
     * 机构联系点哈
     */
    private String orgPerson;

    private String subCode;


    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getParentOrgId() {
        return parentOrgId;
    }

    public void setParentOrgId(String parentOrgId) {
        this.parentOrgId = parentOrgId;
    }

    public String getOrgType() {
        return orgType;
    }

    public void setOrgType(String orgType) {
        this.orgType = orgType;
    }

    public String getRegAddress() {
        return regAddress;
    }

    public void setRegAddress(String regAddress) {
        this.regAddress = regAddress;
    }

    public LocalDateTime getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDateTime regDate) {
        this.regDate = regDate;
    }

    public LocalDate getOperEffDate() {
        return operEffDate;
    }

    public void setOperEffDate(LocalDate operEffDate) {
        this.operEffDate = operEffDate;
    }

    public LocalDate getOperExpDate() {
        return operExpDate;
    }

    public void setOperExpDate(LocalDate operExpDate) {
        this.operExpDate = operExpDate;
    }

    public String getOrgStatus() {
        return orgStatus;
    }

    public void setOrgStatus(String orgStatus) {
        this.orgStatus = orgStatus;
    }

    public String getOrgSeq() {
        return orgSeq;
    }

    public void setOrgSeq(String orgSeq) {
        this.orgSeq = orgSeq;
    }

    public LocalDateTime getDataStamp() {
        return dataStamp;
    }

    public void setDataStamp(LocalDateTime dataStamp) {
        this.dataStamp = dataStamp;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getOrgCcCode() {
        return orgCcCode;
    }

    public void setOrgCcCode(String orgCcCode) {
        this.orgCcCode = orgCcCode;
    }

    public String getExtTag01() {
        return extTag01;
    }

    public void setExtTag01(String extTag01) {
        this.extTag01 = extTag01;
    }

    public String getExtTag02() {
        return extTag02;
    }

    public void setExtTag02(String extTag02) {
        this.extTag02 = extTag02;
    }

    public String getExtTag03() {
        return extTag03;
    }

    public void setExtTag03(String extTag03) {
        this.extTag03 = extTag03;
    }

    public String getExtTag04() {
        return extTag04;
    }

    public void setExtTag04(String extTag04) {
        this.extTag04 = extTag04;
    }

    public String getExtTag05() {
        return extTag05;
    }

    public void setExtTag05(String extTag05) {
        this.extTag05 = extTag05;
    }

    public String getOrgSname() {
        return orgSname;
    }

    public void setOrgSname(String orgSname) {
        this.orgSname = orgSname;
    }

    public String getOrgVersion() {
        return orgVersion;
    }

    public void setOrgVersion(String orgVersion) {
        this.orgVersion = orgVersion;
    }

    public Boolean getPituitary() {
        return isPituitary;
    }

    public void setPituitary(Boolean isPituitary) {
        this.isPituitary = isPituitary;
    }

    public Boolean getOrgLvl() {
        return orgLvl;
    }

    public void setOrgLvl(Boolean orgLvl) {
        this.orgLvl = orgLvl;
    }

    public String getOrgPhone() {
        return orgPhone;
    }

    public void setOrgPhone(String orgPhone) {
        this.orgPhone = orgPhone;
    }

    public String getOrgPerson() {
        return orgPerson;
    }

    public void setOrgPerson(String orgPerson) {
        this.orgPerson = orgPerson;
    }

    public String getSubCode() {
        return subCode;
    }

    public void setSubCode(String subCode) {
        this.subCode = subCode;
    }

    @Override
    public String toString() {
        return "GbOrgs{" +
        "orgId=" + orgId +
        ", orgCode=" + orgCode +
        ", orgName=" + orgName +
        ", parentOrgId=" + parentOrgId +
        ", orgType=" + orgType +
        ", regAddress=" + regAddress +
        ", regDate=" + regDate +
        ", operEffDate=" + operEffDate +
        ", operExpDate=" + operExpDate +
        ", orgStatus=" + orgStatus +
        ", orgSeq=" + orgSeq +
        ", dataStamp=" + dataStamp +
        ", regionId=" + regionId +
        ", orgCcCode=" + orgCcCode +
        ", extTag01=" + extTag01 +
        ", extTag02=" + extTag02 +
        ", extTag03=" + extTag03 +
        ", extTag04=" + extTag04 +
        ", extTag05=" + extTag05 +
        ", orgSname=" + orgSname +
        ", orgVersion=" + orgVersion +
        ", isPituitary=" + isPituitary +
        ", orgLvl=" + orgLvl +
        ", orgPhone=" + orgPhone +
        ", orgPerson=" + orgPerson +
        ", subCode=" + subCode +
        "}";
    }
}
