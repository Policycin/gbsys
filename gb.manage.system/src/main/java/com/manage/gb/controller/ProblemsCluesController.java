package com.manage.gb.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.manage.gb.common.CommonRespInfoJson;
import com.manage.gb.constants.Constants;
import com.manage.gb.constants.ResponseCode;
import com.manage.gb.model.*;
import com.manage.gb.service.AttachmentsService;
import com.manage.gb.service.ProblemsCluesService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 线索征集表 前端控制器
 * </p>
 *
 * @author zxd
 * @since 2020-12-16
 */
@Controller
@RequestMapping("/problemsClues")
public class ProblemsCluesController {

    @Autowired
    private ProblemsCluesService problemsCluesService;

    @Autowired
    private AttachmentsService attachmentsService;


    @PostMapping(path = "/add")
    public CommonRespInfoJson add(@RequestBody @Validated ProblemsCluesVO problemsCluesVO){


        Integer count=problemsCluesService.add(problemsCluesVO);

        return count>0?CommonRespInfoJson.ok():
                CommonRespInfoJson.resp(ResponseCode.SERVER_ERROR,"提交失败");
    }

    @GetMapping(path = "/getcurrstatus")
    @Validated
    public CommonRespInfoJson getcurrstatus(@NotNull String id){

        ProblemsCluesQuery query=new ProblemsCluesQuery();
        query.setId(id);
        ProblemsClues dto=problemsCluesService.queryDetail(query);
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("currtStatus",dto.getStatus());
        jsonObject.put("collectStatus",dto.getCollectStatus());
        jsonObject.put("publicStatus",dto.getPublicStatus());
        jsonObject.put("seleStatus",dto.getSeleStatus());
        jsonObject.put("createTime",dto.getCreateTime());
        jsonObject.put("seleTime",dto.getSeleTime());
        jsonObject.put("collectTime",dto.getCollectTime());
        jsonObject.put("publicTime",dto.getPublicTime());
        return dto!=null?CommonRespInfoJson.data(jsonObject):
                CommonRespInfoJson.resp(ResponseCode.SERVER_ERROR,"查询失败");
    }

    @GetMapping(path = "/detail")
    @Validated
    public CommonRespInfoJson detail(@NotNull String id){

        ProblemsCluesQuery query=new ProblemsCluesQuery();
        query.setId(id);
        ProblemsClues dto=problemsCluesService.queryDetail(query);
        ProblemsCluesVO vo=new ProblemsCluesVO();
        BeanUtils.copyProperties(dto,vo);
        AttachmentsQuery attachmentsQuery=new AttachmentsQuery();
        attachmentsQuery.setAssociatedId(dto.getId());
        List<AttachmentsVO> attachmentsList=attachmentsService.query(attachmentsQuery);

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("detail",vo);
        jsonObject.put("attachments",attachmentsList);

        return dto!=null?CommonRespInfoJson.data(jsonObject):
                CommonRespInfoJson.resp(ResponseCode.SERVER_ERROR,"查询失败");
    }

    @PostMapping(path = "/queryList")
    public CommonRespInfoJson  queryList(@RequestBody  ProblemsCluesQuery query){

        ProblemsClues problemsClues = new ProblemsClues();
        BeanUtils.copyProperties(query,problemsClues);
        QueryWrapper<ProblemsClues> queryWrapper=new QueryWrapper<>();

        queryWrapper.eq(StringUtils.isNotBlank(query.getId()),"id",query.getId())
                .eq(query.getCollectStatus()!=null,"collect_status",query.getCollectStatus())
                .eq(query.getPublicStatus()!=null,"public_status",query.getPublicStatus())
                .eq(query.getSeleStatus()!=null,"sele_status",query.getSeleStatus())
                .eq(query.getCreateTime()!=null,"create_time",query.getCreateTime());
//        Page<ProblemsClues> page = problemsCluesService.page(query, queryWrapper);

        PageInfo<ProblemsClues> objectPageInfo = PageHelper.startPage(1, 10).doSelectPageInfo(()->{
            problemsCluesService.getBaseMapper().selectList(queryWrapper);
        });

        List<JSONObject> result=objectPageInfo.getList().stream().map((item)->{
            return new JSONObject().fluentPut("id",item.getId())
                    .fluentPut("content",item.getContent())
                    .fluentPut("createTime",item.getCreateTime());
        }).collect(Collectors.toList());

        return result!=null?CommonRespInfoJson.data(result):
                CommonRespInfoJson.resp(ResponseCode.SERVER_ERROR,"查询失败");
    }

    @PutMapping(path = "/collecteop")
    public CommonRespInfoJson updateCollect(@RequestBody String id,@RequestBody Integer collectStatus){

        ProblemsClues dto=new ProblemsClues();
        dto.setId(id);
        ProblemsCluesQuery query=new ProblemsCluesQuery();
        query.setId(id);
        ProblemsClues dtoTemp=problemsCluesService.queryDetail(query);
        Integer seleStatus = dtoTemp.getSeleStatus();
        Integer publicStatus = dtoTemp.getPublicStatus();
        if(collectStatus==0){
            if(seleStatus!=null && seleStatus==1){
                return CommonRespInfoJson.resp(ResponseCode.OK,"已选登，不可取消收集");
            }
            if(publicStatus!=null && publicStatus==1){
                return CommonRespInfoJson.resp(ResponseCode.OK,"已发布，不可取消收集");
            }
            dto.setCollectStatus(Constants.PROBLM_STATUS_NO_COLLECTED.getValue());
            dto.setCollectTime(null);
        }

        if(collectStatus==1){
            dto.setCollectStatus(Constants.OPTION_STATUS_COLLECTED.getValue());
            dto.setCollectTime(LocalDateTime.now());
        }
        Integer count=problemsCluesService.update(dto);

        return count>0?CommonRespInfoJson.ok()
                :CommonRespInfoJson.resp(ResponseCode.SERVER_ERROR,"收集失败");
    }

    @PutMapping(path = "/selectop")
    public CommonRespInfoJson updateSelect(@RequestBody String id,@RequestBody Integer selectStatus){
        ProblemsClues dto=new ProblemsClues();
        dto.setId(id);
        ProblemsCluesQuery query=new ProblemsCluesQuery();
        query.setId(id);
        ProblemsClues dtoTemp=problemsCluesService.queryDetail(query);
        Integer collectStatus = dtoTemp.getCollectStatus();
        Integer publicStatus = dtoTemp.getPublicStatus();
        if(selectStatus !=null && selectStatus==0){
            dto.setSeleStatus(Constants.PROBLM_NO_SELECT.getValue());
            dto.setSeleTime(null);
        }

        if(selectStatus !=null && selectStatus==1){

            if(collectStatus!=null && collectStatus==0){
                return CommonRespInfoJson.resp(ResponseCode.OK,"暂未收集，不可选登");
            }
            if(publicStatus!=null && publicStatus==0){
                return CommonRespInfoJson.resp(ResponseCode.OK,"暂未发布，不可选登");
            }
            dto.setSeleStatus(Constants.PROBLM_SELECT.getValue());
            dto.setSeleTime(LocalDateTime.now());
        }
        Integer count=problemsCluesService.update(dto);

        return count>0?CommonRespInfoJson.ok()
                :CommonRespInfoJson.resp(ResponseCode.SERVER_ERROR,"选登失败");
    }

    @PutMapping(path = "/publicop")
    public CommonRespInfoJson updatePublic(@RequestBody String id,@RequestBody Integer publicStatus){

        ProblemsCluesQuery query=new ProblemsCluesQuery();
        query.setId(id);
        ProblemsClues dtoTemp=problemsCluesService.queryDetail(query);
        ProblemsClues dto=new ProblemsClues();
        dto.setId(id);
        Integer collectStatus = dtoTemp.getCollectStatus();
        Integer seleStatus = dtoTemp.getSeleStatus();
        if(publicStatus!=null && publicStatus==0){
            if(seleStatus!=null && seleStatus==1){
                return CommonRespInfoJson.resp(ResponseCode.OK,"已选登，不可取消发布");
            }
            dto.setSeleStatus(Constants.PROBLM_NO_SELECT.getValue());
            dto.setPublicStatus(Constants.PROBLM_STATUS_NO_PUBLIC.getValue());
            dto.setSeleTime(null);
            dto.setPublicTime(null);
        }

        if(publicStatus==1){


            if(collectStatus!=null && collectStatus==0){
                return CommonRespInfoJson.resp(ResponseCode.OK,"暂未收集，不可发布");
            }

            dto.setPublicStatus(Constants.PROBLM_STATUS_PUBLIC.getValue());
            dto.setPublicTime(LocalDateTime.now());
        }
        Integer count=problemsCluesService.update(dto);

        return count>0?CommonRespInfoJson.ok()
                :CommonRespInfoJson.resp(ResponseCode.SERVER_ERROR,"发布失败");
    }

}

