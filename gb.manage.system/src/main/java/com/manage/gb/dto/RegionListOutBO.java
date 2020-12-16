package com.manage.gb.dto;

/**
 * @author zhangzhenfu
 * @Description: 行政区划列表outBO
 */
public class RegionListOutBO {

    /**
     * 行政区域编码
     */
    private String regionCode;

    /**
     * 区划名称
     */
    private String regionName;

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }
}
