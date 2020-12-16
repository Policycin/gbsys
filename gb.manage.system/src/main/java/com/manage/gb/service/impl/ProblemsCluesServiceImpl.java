package com.manage.gb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.manage.gb.constants.Constants;
import com.manage.gb.model.ProblemsCluesQuery;
import com.manage.gb.model.ProblemsCluesVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.manage.gb.dao.ProblemsCluesMapper;
import com.manage.gb.model.ProblemsClues;
import com.manage.gb.service.ProblemsCluesService;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * <p>
 * 线索征集表 服务实现类
 * </p>
 *
 * @author zxd
 * @since 2020-12-16
 */
@Service
public class ProblemsCluesServiceImpl extends ServiceImpl<ProblemsCluesMapper, ProblemsClues> implements ProblemsCluesService {

    @Resource
    private ProblemsCluesMapper problemsCluesMapper;

    @Override
    public Integer add(ProblemsCluesVO problemsCluesVO) {

        ProblemsClues dto=new ProblemsClues();
        BeanUtils.copyProperties(problemsCluesVO,dto);

        dto.setCreateTime(LocalDateTime.now());
        dto.setSeleStatus(Constants.PROBLM_NO_SELECT.getValue());
        dto.setPublicStatus(Constants.PROBLM_STATUS_NO_PUBLIC.getValue());
        dto.setCollectStatus(Constants.PROBLM_STATUS_NO_COLLECTED.getValue());
        dto.setStatus(Constants.PROBLM_STATUS_COMMITED.getValue());

        int insert = problemsCluesMapper.insert(dto);

        return insert;
    }

    @Override
    public ProblemsClues queryDetail(ProblemsCluesQuery query) {
        QueryWrapper queryWrapper=new QueryWrapper(new ProblemsClues());
        queryWrapper.eq("id",query.getId());

        ProblemsClues problemsClues = problemsCluesMapper.selectOne(queryWrapper);

        return problemsClues;
    }

    @Override
    public Integer update(ProblemsClues dto) {
        return problemsCluesMapper.updateById(dto);
    }


}
