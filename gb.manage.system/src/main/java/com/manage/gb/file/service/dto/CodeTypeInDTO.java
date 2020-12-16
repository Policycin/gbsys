package com.manage.gb.file.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by guopx on 2019/5/10.
 */
@ApiModel(value="公共代码表请求对象",description="用于获取系统公共代码的请求信息")
public class CodeTypeInDTO  {

    /** 代码类型;代码类型（存英文） */
    @ApiModelProperty(value="代码类型（必输其一）",name="codeType",example="SUPERVISE_DEPT")
    private String codeType ;
    /** 代码标志;代码在获取时候使用的标志 */
    @ApiModelProperty(value="代码标志(非必输)",name="codeKey")
    private String codeKey ;
    /**代码类型名称*/
    @ApiModelProperty(value="代码类型名称(必输其一 模糊匹配)",name="codeTypeName")
    private String codeTypeName;
    /** 代码值;代码保存时候的具体值 */
    @ApiModelProperty(value="代码值",name="codeValue")
    private String codeValue ;
    /** 代码名称;代码对应的中文名称 */
    @ApiModelProperty(value="对应代码值的名称（非必输，模糊匹配）",name="codeName")
    private String codeName ;
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
