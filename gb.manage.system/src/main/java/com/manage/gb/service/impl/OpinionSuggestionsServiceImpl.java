package com.manage.gb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.manage.gb.constants.Constants;
import com.manage.gb.dao.OpinionSuggestionsMapper;
import com.manage.gb.model.OpinionSuggestions;
import com.manage.gb.model.OpinionSuggestionsQuery;
import com.manage.gb.model.OpinionSuggestionsVO;
import com.manage.gb.service.OpinionSuggestionsService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * <p>
 * 意见建议表 服务实现类
 * </p>
 *
 * @author zxd
 * @since 2020-12-16
 */
@Service
public class OpinionSuggestionsServiceImpl extends ServiceImpl<OpinionSuggestionsMapper, OpinionSuggestions> implements OpinionSuggestionsService {

    @Resource
    private OpinionSuggestionsMapper opinionSuggestionsMapper;

    @Override
    public Integer add(OpinionSuggestionsVO opinionSuggestionsVO) {

        OpinionSuggestions dto=new OpinionSuggestions();
        BeanUtils.copyProperties(opinionSuggestionsVO,dto);

        dto.setCreateTime(LocalDateTime.now());
        dto.setSeleStatus(Constants.PROBLM_NO_SELECT.getValue());
        dto.setCollectStatus(Constants.PROBLM_STATUS_NO_COLLECTED.getValue());
        dto.setStatus(Constants.OPTION_STATUS_COMMITED.getValue());

        int insert = opinionSuggestionsMapper.insert(dto);

        return insert;
    }

    @Override
    public OpinionSuggestions queryDetail(OpinionSuggestionsQuery query) {
        QueryWrapper queryWrapper=new QueryWrapper(new OpinionSuggestions());
        queryWrapper.eq("id",query.getId());

        OpinionSuggestions opinionSuggestions = opinionSuggestionsMapper.selectOne(queryWrapper);

        return opinionSuggestions;
    }

    @Override
    public Integer update(OpinionSuggestions dto) {
        return opinionSuggestionsMapper.updateById(dto);
    }


}
