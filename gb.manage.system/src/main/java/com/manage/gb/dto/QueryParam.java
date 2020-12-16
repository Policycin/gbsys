package com.manage.gb.dto;

import lombok.Data;

/**
 *
 * @author 36326669
 * @date 2019/7/22
 */
@Data
public class QueryParam {

    /**
     * 参数值
     */
    private String value ;

    /**
     *0：精确匹配，1：模糊匹配(模糊匹配采⽤用%xxx%)
     */
    private Integer fuzy ;

}
