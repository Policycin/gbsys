package com.manage.gb.dto;

/**
 * ClassName: OrganizationQueryListDto
 *
 * @author WangYiZhou
 * @Description: TODO
 * @date 2019-04-29
 */
public class RegionCodeQueryInDTO {

    private String regionCode;

    private String regionName;

    private Integer regionLevel;

    private String parentRegionCode;

    private Integer provinceValue;

    private Integer cityValue;

    private Integer townValue;

    private Integer countryValue;


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

    public Integer getRegionLevel() {
        return regionLevel;
    }

    public void setRegionLevel(Integer regionLevel) {
        this.regionLevel = regionLevel;
    }

    public String getParentRegionCode() {
        return parentRegionCode;
    }

    public void setParentRegionCode(String parentRegionCode) {
        this.parentRegionCode = parentRegionCode;
    }

    public Integer getProvinceValue() {
        return provinceValue;
    }

    public void setProvinceValue(Integer provinceValue) {
        this.provinceValue = provinceValue;
    }

    public Integer getCityValue() {
        return cityValue;
    }

    public void setCityValue(Integer cityValue) {
        this.cityValue = cityValue;
    }

    public Integer getTownValue() {
        return townValue;
    }

    public void setTownValue(Integer townValue) {
        this.townValue = townValue;
    }

    public Integer getCountryValue() {
        return countryValue;
    }

    public void setCountryValue(Integer countryValue) {
        this.countryValue = countryValue;
    }


}
