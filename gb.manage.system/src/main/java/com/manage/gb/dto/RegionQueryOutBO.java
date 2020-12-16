package com.manage.gb.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 *
 */
@Data
@ApiModel(value="区划详细信息",description="区划详细信息")
public class RegionQueryOutBO {

    private String regionName; // 区划名称

    private String regionCode; // 区划名称

    private String regionLevel; // 区划层级

    private String parentRegionCode;// 所属上级区划

    private String parentRegionName;// 所属上级区划名称

    private Integer regionSeq; // 区划排序
}
