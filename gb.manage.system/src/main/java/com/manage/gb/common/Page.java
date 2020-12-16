package com.manage.gb.common;

import com.github.pagehelper.IPage;

public class Page<T> implements IPage {

    private Integer pageNum;
    private Integer pageSize;
    private String  orderBy;

    public Page() {

    }

    public Page(Integer pageNum, Integer pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    @Override
    public Integer getPageNum() {
        return this.pageNum;
    }

    @Override
    public Integer getPageSize() {
        return this.pageSize;
    }

    @Override
    public String getOrderBy() {
        return this.orderBy;
    }

}
