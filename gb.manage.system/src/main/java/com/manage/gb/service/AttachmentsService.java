package com.manage.gb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.manage.gb.model.Attachments;
import com.manage.gb.model.AttachmentsQuery;
import com.manage.gb.model.AttachmentsVO;

import java.util.List;

/**
 * <p>
 * 附件表 服务类
 * </p>
 *
 * @author zxd
 * @since 2020-12-16
 */
public interface AttachmentsService extends IService<Attachments> {

    List<AttachmentsVO> query(AttachmentsQuery attachmentsQuery);
}
