package com.manage.gb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.manage.gb.model.AttachmentsQuery;
import com.manage.gb.model.AttachmentsVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.manage.gb.dao.AttachmentsMapper;
import com.manage.gb.model.Attachments;
import com.manage.gb.service.AttachmentsService;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 附件表 服务实现类
 * </p>
 *
 * @author zxd
 * @since 2020-12-16
 */
@Service
public class AttachmentsServiceImpl extends ServiceImpl<AttachmentsMapper, Attachments> implements AttachmentsService {

    @Resource
    private AttachmentsMapper attachmentsMapper;

    @Override
    public List<AttachmentsVO> query(AttachmentsQuery attachmentsQuery) {

        QueryWrapper<Attachments> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("associAttachmentsated_id",attachmentsQuery.getAssociatedId());

        Page<Attachments> page=new Page<>(1,10);

        Page<Attachments> selectPage = attachmentsMapper.selectPage(page, queryWrapper);

        List<AttachmentsVO> result=selectPage.getRecords().stream().map((item)->{
            AttachmentsVO vo=new AttachmentsVO();
            BeanUtils.copyProperties(item,vo);
            return vo;
        }).collect(Collectors.toList());

        return result;
    }
}
