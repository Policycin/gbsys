package com.manage.gb.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.manage.gb.common.CommonRespInfo;
import com.manage.gb.constants.ResponseCode;
import com.manage.gb.dto.RegionCodeQueryInBo;
import com.manage.gb.dto.RegionCodeQueryInDTO;
import com.manage.gb.dto.RegionCodeQueryOutBo;
import com.manage.gb.dto.RegionListOutBO;
import com.manage.gb.dto.RegionListOutDTO;
import com.manage.gb.file.service.response.StatusEnum;
import com.manage.gb.service.RegionCodeService;

/**
 * @Description 行政区划
 * @Author zhangzhenfu
 * @Version 1.0
 **/
@RestController
@RequestMapping(value = "/regionCode")
public class RegionCodeController {

    private static Logger logger = LoggerFactory.getLogger(RegionCodeController.class);

    @Autowired
    private RegionCodeService regionCodeService;

    @PostMapping("/pageRegionByParam")
    public CommonRespInfo pageRegionByParam(@RequestBody RegionCodeQueryInBo inBo) {
        CommonRespInfo comm = new CommonRespInfo();
        Page<RegionCodeQueryOutBo> page = regionCodeService.pageRegionByParam(inBo);
        PageInfo pageInfo = new PageInfo(page);
        comm.setResultCode(ResponseCode.OK);
        comm.setResultMsg("查询成功");
        comm.setResultData(pageInfo);
        return comm;
    }

    /**
     * 根据上级区域编码查询下级区域列表
     * @param parentRegionCode
     * @return
     */
    @GetMapping("/queryRegionList")
    public CommonRespInfo<RegionListOutDTO> queryRegionList(@RequestParam("parentRegionCode") String parentRegionCode) {
        CommonRespInfo comm = new CommonRespInfo();
        if (StringUtils.isBlank(parentRegionCode)) {
            parentRegionCode = "000000";
        }
        List<RegionListOutBO> regionListOutBOList =  regionCodeService.queryRegionCodeList(parentRegionCode);
        RegionListOutDTO outDTO = null;
        List<RegionListOutDTO> regionList = new ArrayList<>();
        for (RegionListOutBO outBO : regionListOutBOList) {
            outDTO = new RegionListOutDTO();
            BeanUtils.copyProperties(outBO, outDTO);
            regionList.add(outDTO);
        }
        comm.setResultCode(ResponseCode.OK + "");
        comm.setResultMsg("查询成功");
        comm.setResultData(regionList);
        return comm;
    }

    @PostMapping("/getRegionByParam")
    public CommonRespInfo<RegionListOutDTO> getRegionByParam(@RequestBody RegionCodeQueryInDTO inDTO) {
        RegionCodeQueryInBo inBo=new RegionCodeQueryInBo();
        BeanUtils.copyProperties(inDTO,inBo);
        RegionCodeQueryOutBo outBo =  regionCodeService.getRegionByParam(inBo);
        RegionListOutDTO outDTO = new RegionListOutDTO();
       if(outBo!=null){
           BeanUtils.copyProperties(outBo,outDTO);
       }
        return CommonRespInfo.data(outDTO);
    }

    @GetMapping("/getChildRegionList")
    public CommonRespInfo getChildRegionList(@RequestParam("parentRegionCode") String parentRegionCode) {
        CommonRespInfo comm = new CommonRespInfo();
        if (StringUtils.isBlank(parentRegionCode)) {
            parentRegionCode = "000000";
        }
        List<RegionListOutBO> regionListOutBOList =  regionCodeService.getChildRegionList(parentRegionCode);
        return CommonRespInfo.data(regionListOutBOList);
    }

    @GetMapping("/getRegionListByParent")
    public CommonRespInfo getRegionListByParent(@RequestParam("parentRegionCode") String parentRegionCode) {
        if (StringUtils.isBlank(parentRegionCode)) {
            parentRegionCode = "000000";
        }
        List<Map<String, String>> regionListOutBOList =  regionCodeService.getRegionListByParent(parentRegionCode);
        return CommonRespInfo.data(regionListOutBOList);
    }
}
