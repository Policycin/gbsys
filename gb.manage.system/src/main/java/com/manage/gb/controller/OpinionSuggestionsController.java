package com.manage.gb.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.manage.gb.common.CommonRespInfoJson;
import com.manage.gb.constants.Constants;
import com.manage.gb.constants.ResponseCode;
import com.manage.gb.model.*;
import com.manage.gb.service.AttachmentsService;
import com.manage.gb.service.OpinionSuggestionsService;
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
 * 意见建议表 前端控制器
 * </p>
 *
 * @author zxd
 * @since 2020-12-16
 */
@Controller
@RequestMapping("/opinionSuggestions")
public class OpinionSuggestionsController {

    @Autowired
    private OpinionSuggestionsService opinionSuggestionsService;

    @Autowired
    private AttachmentsService attachmentsService;


    @PostMapping(path = "/add")
    public CommonRespInfoJson add(@RequestBody @Validated OpinionSuggestionsVO opinionSuggestionsVO){


        Integer count=opinionSuggestionsService.add(opinionSuggestionsVO);

        return count>0?CommonRespInfoJson.ok():
                CommonRespInfoJson.resp(ResponseCode.SERVER_ERROR,"提交失败");
    }

    @GetMapping(path = "/getcurrstatus")
    @Validated
    public CommonRespInfoJson getcurrstatus(@NotNull String id){

        OpinionSuggestionsQuery query=new OpinionSuggestionsQuery();
        query.setId(id);
        OpinionSuggestions dto=opinionSuggestionsService.queryDetail(query);
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("currtStatus",dto.getStatus());
        jsonObject.put("collectStatus",dto.getCollectStatus());
        jsonObject.put("seleStatus",dto.getSeleStatus());
        jsonObject.put("createTime",dto.getCreateTime());
        jsonObject.put("seleTime",dto.getSeleTime());
        jsonObject.put("collectTime",dto.getCollectTime());
        return dto!=null?CommonRespInfoJson.data(jsonObject):
                CommonRespInfoJson.resp(ResponseCode.SERVER_ERROR,"查询失败");
    }

    @GetMapping(path = "/detail")
    @Validated
    public CommonRespInfoJson detail(@NotNull String id){

        OpinionSuggestionsQuery query=new OpinionSuggestionsQuery();
        query.setId(id);
        OpinionSuggestions dto=opinionSuggestionsService.queryDetail(query);
        OpinionSuggestionsVO vo=new OpinionSuggestionsVO();
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

    @GetMapping(path = "/queryList")
    @Validated
    public CommonRespInfoJson  queryList(@NotNull Integer pageNum,@NotNull Integer pageSize){

        OpinionSuggestionsQuery query=new OpinionSuggestionsQuery();
        query.setCurrent(pageNum);
        query.setSize(pageSize);
        query.setSeleStatus(true);
        OpinionSuggestions opinionSuggestions = new OpinionSuggestions();
        BeanUtils.copyProperties(query,opinionSuggestions);
        QueryWrapper<OpinionSuggestions> queryWrapper=new QueryWrapper<>(opinionSuggestions);
        queryWrapper.eq(StringUtils.isNotBlank(query.getId()),"id",query.getId())
                .eq(query.getCollectStatus()!=null,"collect_status",query.getCollectStatus())
                .eq(query.getSeleStatus()!=null,"sele_status",query.getSeleStatus())
                .eq(query.getCreateTime()!=null,"create_time",query.getCreateTime());
        Page<OpinionSuggestions> page = opinionSuggestionsService.page(query, queryWrapper);

        List<JSONObject> result=page.getRecords().stream().map((item)->{
            return new JSONObject().fluentPut("id",item.getId())
                    .fluentPut("content",item.getContent())
                    .fluentPut("createTime",item.getCreateTime());
        }).collect(Collectors.toList());

        return result!=null?CommonRespInfoJson.data(result):
                CommonRespInfoJson.resp(ResponseCode.SERVER_ERROR,"查询失败");
    }

    @PutMapping(path = "/collecteop")
    public CommonRespInfoJson updateCollect(@RequestBody String id,@RequestBody Integer collectStatus){

        OpinionSuggestions dto=new OpinionSuggestions();
        dto.setId(id);
        OpinionSuggestionsQuery query=new OpinionSuggestionsQuery();
        query.setId(id);
        OpinionSuggestions dtoTemp=opinionSuggestionsService.queryDetail(query);
        Integer seleStatus = dtoTemp.getSeleStatus();
        if(collectStatus==0){
            if(seleStatus!=null && seleStatus==1){
                return CommonRespInfoJson.resp(ResponseCode.OK,"已选登，不可取消收集");
            }
            dto.setCollectStatus(Constants.PROBLM_STATUS_NO_COLLECTED.getValue());
        }

        if(collectStatus==1){
            dto.setCollectStatus(Constants.OPTION_STATUS_COLLECTED.getValue());
            dto.setCollectTime(LocalDateTime.now());
        }
        Integer count=opinionSuggestionsService.update(dto);

        return count>0?CommonRespInfoJson.ok()
                :CommonRespInfoJson.resp(ResponseCode.SERVER_ERROR,"收集失败");
    }

    @PutMapping(path = "/selectop")
    public CommonRespInfoJson updateSelect(@RequestBody String id,@RequestBody Integer selectStatus){
        OpinionSuggestions dto=new OpinionSuggestions();
        dto.setId(id);
        OpinionSuggestionsQuery query=new OpinionSuggestionsQuery();
        query.setId(id);
        OpinionSuggestions dtoTemp=opinionSuggestionsService.queryDetail(query);
        Integer collectStatus = dtoTemp.getCollectStatus();
        if(selectStatus !=null && selectStatus==0){
            dto.setSeleStatus(Constants.PROBLM_NO_SELECT.getValue());
        }

        if(selectStatus !=null && selectStatus==1){

            if(collectStatus!=null && collectStatus==0){
                return CommonRespInfoJson.resp(ResponseCode.OK,"暂未收集，不可选登");
            }
            dto.setSeleStatus(Constants.PROBLM_SELECT.getValue());
            dto.setSeleTime(LocalDateTime.now());
        }
        Integer count=opinionSuggestionsService.update(dto);

        return count>0?CommonRespInfoJson.ok()
                :CommonRespInfoJson.resp(ResponseCode.SERVER_ERROR,"选登失败");
    }

}

