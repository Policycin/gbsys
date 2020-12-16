package com.manage.gb.service.impl;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.manage.gb.dao.RegionCodeMapper;
import com.manage.gb.dto.RegionAndDeptListOutBo;
import com.manage.gb.dto.RegionCodeQueryInBo;
import com.manage.gb.dto.RegionCodeQueryOutBo;
import com.manage.gb.dto.RegionListOutBO;
import com.manage.gb.service.RegionCodeService;

/**
 * @Description 行政区划
 * @Author zhangzhenfu
 * @Version 1.0
 **/
@Service
public class RegionCodeServiceImpl implements RegionCodeService {

    @Autowired
    private RegionCodeMapper regionCodeMapper;

    @Override
    public RegionCodeQueryOutBo getRegionByParam(RegionCodeQueryInBo inBo) {
        return regionCodeMapper.getByParam(inBo);
    }

    @Override
    public List<RegionCodeQueryOutBo> listRegionByParam(RegionCodeQueryInBo inBo) {
        return regionCodeMapper.listByParam(inBo);
    }

    @Override
    public Page<RegionCodeQueryOutBo> pageRegionByParam(RegionCodeQueryInBo inBo) {
        if (inBo.getPageNum() != null && inBo.getPageSize() != null) {
            PageHelper.startPage(inBo.getPageNum(), inBo.getPageSize());
        } else {
            PageHelper.startPage(1, 10);
        }
        return regionCodeMapper.pageByParam(inBo);
    }

    @Override
    public List<RegionAndDeptListOutBo> queryRegionList(String regionCode) {
        return regionCodeMapper.queryRegionList(regionCode);
    }

    @Override
    public List<RegionListOutBO> queryRegionCodeList(String parentRegionCode) {
        return regionCodeMapper.queryRegionCodeList(parentRegionCode);
    }

    @Override
    public List<RegionListOutBO> getChildRegionList(String parentRegionCode) {
        return regionCodeMapper.getChildRegionList(parentRegionCode);
    }

    @Override
    public List<Map<String, String>> getRegionListByParent(String parentRegionCode) {
        List<Map<String,String>> regionMapList = new ArrayList<>();
        Map<String, String> map = regionCodeMapper.getRegionById(parentRegionCode);
        List<Map<String,String>> mapList = regionCodeMapper.getRegionListByParent(parentRegionCode);
        regionMapList.add(map);
        regionMapList.addAll(mapList);
        return regionMapList;
    }
}
