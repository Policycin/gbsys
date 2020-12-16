package com.manage.gb.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by 01027695 on 2019/6/3.
 * 分页参数控制
 */
public class PageDTO {
    /** 起始页 */
    @ApiModelProperty(value="起始页 ",name="pageNum",example="1",required=false)
    @TableField(exist = false)
    private Integer pageNum;
    /** 每页记录数 */
    @ApiModelProperty(value="每页记录数",name="pageSize",example="10",required=false)
    @TableField(exist = false)
    private Integer pageSize;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
