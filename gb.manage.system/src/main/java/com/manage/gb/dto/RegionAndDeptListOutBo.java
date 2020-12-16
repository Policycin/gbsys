package com.manage.gb.dto;

/**
 * @author zhangzhenfu
 * @Description: 行政区划或部门outBO
 */
public class RegionAndDeptListOutBo {

    /**
     * 行政区域编码
     */
    private String regionCode;

    /**
     * 机构名称或区划名称
     */
    private String name;

    /**
     * 数据类型，【0|行政区划，1|虚拟机构, 2|机构】
     */
    private Integer type;

    /**
     * 区划等级
     */
    private Integer regionLevel;

    /**
     * 部门编码
     */
    private String orgCode;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getRegionLevel() {
        return regionLevel;
    }

    public void setRegionLevel(Integer regionLevel) {
        this.regionLevel = regionLevel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }
}
