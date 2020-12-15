package com.manage.gb.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import lombok.Data;

import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * @author zxd
 * @since 2020-12-15
 */
@Data
public class ProblemsCluesDTO implements Serializable {

    private static final long serialVersionUID=1L;
    
    /**
     * 主体名称
     */
    private String subjectName;
    
    /**
     * 统一社会信用代码
     */
    private String uniscid;
    
    /**
     * 企业/机构属地
     */
    private String orgTerritorial;
    
    /**
     * 线索内容
     */
    private String content;
    
    /**
     * 是否允许公开	0.不允许1.允许
     */
    private Boolean showPublic;
    
    /**
     * 验证码
     */
    private String verifiCode;
    
}
