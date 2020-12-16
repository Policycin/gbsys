package com.manage.gb.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.pagehelper.Page;
import com.manage.gb.dto.RegionAndDeptListOutBo;
import com.manage.gb.dto.RegionCodeQueryInBo;
import com.manage.gb.dto.RegionCodeQueryOutBo;
import com.manage.gb.dto.RegionListOutBO;
import com.manage.gb.model.Attachments;
import com.manage.gb.model.ProblemsClues;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Description 行政区划
 * @Author zhangzhenfu
 * @Version 1.0
 **/
public interface RegionCodeMapper extends BaseMapper<RegionCodeQueryOutBo> {

    /**
     * 根据参数查询区域信息
     *
     * @param regionCodeQueryInBo
     * @return
     */
    RegionCodeQueryOutBo getByParam(RegionCodeQueryInBo regionCodeQueryInBo);

    /**
     * 根据参数查询区域列表信息
     *
     * @param regionCodeQueryInBo
     * @return
     */
    List<RegionCodeQueryOutBo> listByParam(RegionCodeQueryInBo regionCodeQueryInBo);

    /**
     * 根据参数分页查询区域列表信息
     *
     * @param regionCodeQueryInBo
     * @return
     */
    Page<RegionCodeQueryOutBo> pageByParam(RegionCodeQueryInBo regionCodeQueryInBo);

    /**
     * 查询行政区划
     *
     * @param regionCode
     * @return
     */
    List<RegionAndDeptListOutBo> queryRegionList(String regionCode);

    /**
     * 根据上级区域编码查询下级区域列表
     *
     * @param parentRegionCode
     * @return
     */
    List<RegionListOutBO> queryRegionCodeList(@Param("parentRegionCode") String parentRegionCode);

    List<RegionListOutBO> getChildRegionList(@Param("parentRegionCode") String parentRegionCode);

    /**
     * 根据区域等级查询区域列表
     *
     * @param map 区域、等级
     * @return List
     */
    List<Map<String, String>> queryRegionCodeByLevel(Map<String, Object> map);

    /**
     * 查询子级区划编码
     *
     * @param parentRegionCode 父级区划编码
     * @return List
     */
    List<Map<String, String>> getRegionListByParent(@Param("parentRegionCode") String parentRegionCode);

    Map<String, String> getRegionById(@Param("regionCode")String regionCode);

}
