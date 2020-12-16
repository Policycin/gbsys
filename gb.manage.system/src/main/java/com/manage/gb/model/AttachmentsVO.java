package com.manage.gb.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 附件表
 * </p>
 *
 * @author zxd
 * @since 2020-12-16
 */
@TableName("attachments")
public class AttachmentsVO implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 附件类型
     */
    private String fileType;

    /**
     * 附件重名名称
     */
    private String reFileName;

    /**
     * 附件大小，kb
     */
    private String fileSize;


}
