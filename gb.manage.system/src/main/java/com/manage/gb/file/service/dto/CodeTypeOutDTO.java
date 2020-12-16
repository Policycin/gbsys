package com.manage.gb.file.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by guopx on 2019/5/10.
 */
@ApiModel(value="公共代码表请求对象",description="用于获取系统公共代码的请求信息")
public class CodeTypeOutDTO {

    /** 代码类型;代码类型（存英文） */
    @ApiModelProperty(value="代码类型（必输）",name="codeType",example="SUPERVISE_DEPT",required=true)
    private String codeType ;

    /** 代码类型名称;代码类型名称（中文描述） */
    @ApiModelProperty(value="代码类型名称",name="codeTypeName",example="监管部门")
    private String codeTypeName ;

    /** 代码标志;代码在获取时候使用的标志 */
    @ApiModelProperty(value="代码标志(非必输)",name="codeKey")
    private String codeKey ;

    /** 代码值;代码保存时候的具体值 */
    @ApiModelProperty(value="代码值",name="codeValue")
    private String codeValue ;

    /** 代码名称;代码对应的中文名称 */
    @ApiModelProperty(value="对应代码值的名称（非必输，模糊匹配）",name="codeName")
    private String codeName ;

    /** 代码辅助信息_1;代码辅助信息_1 */
    @ApiModelProperty(value="代码辅助信息_1",name="codeValue1")
    private String codeValue1;

    /** 代码辅助信息_2;代码辅助信息_2 */
    @ApiModelProperty(value="代码辅助信息_2",name="codeValue2")
    private String codeValue2;

    private Integer order;

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    /** 代码类型;代码类型（存英文） */
    public String getCodeType(){
        return this.codeType;
    }
    /** 代码类型;代码类型（存英文） */
    public void setCodeType(String codeType){
        this.codeType = codeType;
    }
    /** 代码标志;代码在获取时候使用的标志 */
    public String getCodeKey(){
        return this.codeKey;
    }
    /** 代码标志;代码在获取时候使用的标志 */
    public void setCodeKey(String codeKey){
        this.codeKey = codeKey;
    }
    /** 代码值;代码保存时候的具体值 */
    public String getCodeValue(){
        return this.codeValue;
    }

    public String getCodeValue1() {
        return codeValue1;
    }

    public void setCodeValue1(String codeValue1) {
        this.codeValue1 = codeValue1;
    }

    public String getCodeValue2() {
        return codeValue2;
    }

    public void setCodeValue2(String codeValue2) {
        this.codeValue2 = codeValue2;
    }

    /** 代码值;代码保存时候的具体值 */

    public void setCodeValue(String codeValue){
        this.codeValue = codeValue;
    }
    /** 代码名称;代码对应的中文名称 */
    public String getCodeName(){
        return this.codeName;
    }
    /** 代码名称;代码对应的中文名称 */
    public void setCodeName(String codeName){
        this.codeName = codeName;
    }

    public String getCodeTypeName() {
        return codeTypeName;
    }

    public void setCodeTypeName(String codeTypeName) {
        this.codeTypeName = codeTypeName;
    }
}
