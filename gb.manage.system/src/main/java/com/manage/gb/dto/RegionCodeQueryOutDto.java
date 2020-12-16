package com.manage.gb.dto;

import java.util.List;

public class RegionCodeQueryOutDto {

    private String regionCode;

    private String regionName;

    private List<RegionCodeQueryOutDto> regionCodeList;

    public List<RegionCodeQueryOutDto> getRegionCodeList() {
        return regionCodeList;
    }

    public void setRegionCodeList(List<RegionCodeQueryOutDto> regionCodeList) {
        this.regionCodeList = regionCodeList;
    }

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
