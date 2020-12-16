package com.manage.gb.file.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * Created by guopx on 2019/5/10.
 */
@ApiModel(value="公共代码树表请求对象",description="用于获取系统公共代码树的请求信息")
public class CodeTypeTreeOutDTO implements Serializable{

    /** 代码类型;代码类型（存英文） */
    @ApiModelProperty(value="代码类型（必输）",name="codeType",example="industry_category",required=true)
    private String codeType ;

    /** 父级代码值 */
    private String parentKey ;

    /** 代码值;代码保存时候的具体值 */
    private String codeValue ;

    /** 代码名称;代码对应的中文名称 */
    private String codeName ;

    private Integer codeLevel;

    private List<CodeTypeTreeOutDTO> treeOutDTOList ;

    public String getCodeType() {
        return codeType;
    }

    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }

    public String getParentKey() {
        return parentKey;
    }

    public void setParentKey(String parentKey) {
        this.parentKey = parentKey;
    }

    public String getCodeValue() {
        return codeValue;
    }

    public void setCodeValue(String codeValue) {
        this.codeValue = codeValue;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public Integer getCodeLevel() {
        return codeLevel;
    }

    public void setCodeLevel(Integer codeLevel) {
        this.codeLevel = codeLevel;
    }

    public List<CodeTypeTreeOutDTO> getTreeOutDTOList() {
        return treeOutDTOList;
    }

    public void setTreeOutDTOList(List<CodeTypeTreeOutDTO> treeOutDTOList) {
        this.treeOutDTOList = treeOutDTOList;
    }
}
