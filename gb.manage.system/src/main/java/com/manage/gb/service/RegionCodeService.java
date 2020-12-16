package com.manage.gb.service;

import com.github.pagehelper.Page;
import com.manage.gb.dto.RegionAndDeptListOutBo;
import com.manage.gb.dto.RegionCodeQueryInBo;
import com.manage.gb.dto.RegionCodeQueryOutBo;
import com.manage.gb.dto.RegionListOutBO;

import java.util.List;
import java.util.Map;

/**
 * @Description 行政区划
 * @Author zhangzhenfu
 * @Version 1.0
 **/
public interface RegionCodeService {

    RegionCodeQueryOutBo getRegionByParam(RegionCodeQueryInBo inBo);

    List<RegionCodeQueryOutBo> listRegionByParam(RegionCodeQueryInBo inBo);

    Page<RegionCodeQueryOutBo> pageRegionByParam(RegionCodeQueryInBo inBo);

    /**
     * 查询行政区划
     *
     * @param regionCode
     * @return
     */
    List<RegionAndDeptListOutBo> queryRegionList(String regionCode);

    /**
     * 根据上级区域编码查询下级区域列表
     * @param parentRegionCode
     * @return
     */
    List<RegionListOutBO> queryRegionCodeList(String parentRegionCode);

    List<RegionListOutBO> getChildRegionList(String parentRegionCode);


    List<Map<String, String>> getRegionListByParent(String parentRegionCode);
}
