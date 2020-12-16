package com.manage.gb.file.service.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by qiuhuansheng on 2019/5/8 0008.
 */
public class RcNumberConfigDto implements Serializable {

    /** 编号ID;技术主键 */
    private Integer id ;
    /** 编号类型;编号的具体类型 */
    private String numType ;
    /** 编号类型名称;编号对应的中文名称 */
    private String numName ;
    /** 代码类型;组成编号的代码类型 */
    private String codeType ;
    /** 参数标志;标识对应的代码类型是以什么属性在参数中传递的 */
    private String paramKey ;
    /** 直接读取入参;是否直接读取入参数据，作为编号的一部分.
     1表示true，直接读取，0表示false，不直接读取 */
    private boolean directReadInParm ;
    /** 序列类型;自增序列的类型，用户获取统一类型的编码的下自增序列号 */
    private String sequenceType ;
    /** 序列前缀位数;以哪些顺序号对应的入参作为开头，如有多个用逗号隔开。
     如：目录清单的主项顺序号前面是以行政区划和中央指导部门作为它是否同一类型的判断依据，如果是前缀相同，则递增，否则顺序号重新从0001开始计算。 */
    private String sequencePrefix ;
    /** 通用类型;编号表提供一些基础类型供生成编号使用 */
    private String commType ;
    /** 通用值;基础类型要使用的值 */
    private String commValue ;
    /** 顺序号;编号组成的顺序号 */
    private Integer serialNum ;
    /** 乐观锁 */
    private Integer revision ;
    /** 创建人 */
    private String createdBy ;
    /** 创建时间 */
    private Date createdTime ;
    /** 更新人 */
    private String updatedBy ;
    /** 更新时间 */
    private Date updatedTime ;

    /** 编号ID;技术主键 */
    public Integer getId(){
        return this.id;
    }
    /** 编号ID;技术主键 */
    public void setId(Integer id){
        this.id = id;
    }
    /** 编号类型;编号的具体类型 */
    public String getNumType(){
        return this.numType;
    }
    /** 编号类型;编号的具体类型 */
    public void setNumType(String numType){
        this.numType = numType;
    }
    /** 编号类型名称;编号对应的中文名称 */
    public String getNumName(){
        return this.numName;
    }
    /** 编号类型名称;编号对应的中文名称 */
    public void setNumName(String numName){
        this.numName = numName;
    }
    /** 代码类型;组成编号的代码类型 */
    public String getCodeType(){
        return this.codeType;
    }
    /** 代码类型;组成编号的代码类型 */
    public void setCodeType(String codeType){
        this.codeType = codeType;
    }
    /** 参数标志;标识对应的代码类型是以什么属性在参数中传递的 */
    public String getParamKey(){
        return this.paramKey;
    }
    /** 参数标志;标识对应的代码类型是以什么属性在参数中传递的 */
    public void setParamKey(String paramKey){
        this.paramKey = paramKey;
    }
    /** 直接读取入参;是否直接读取入参数据，作为编号的一部分.
     1表示true，直接读取，0表示false，不直接读取 */
    public boolean getDirectReadInParm(){
        return this.directReadInParm;
    }
    /** 直接读取入参;是否直接读取入参数据，作为编号的一部分.
     1表示true，直接读取，0表示false，不直接读取 */
    public void setDirectReadInParm(boolean directReadInParm){
        this.directReadInParm = directReadInParm;
    }
    /** 序列类型;自增序列的类型，用户获取统一类型的编码的下自增序列号 */
    public String getSequenceType(){
        return this.sequenceType;
    }
    /** 序列类型;自增序列的类型，用户获取统一类型的编码的下自增序列号 */
    public void setSequenceType(String sequenceType){
        this.sequenceType = sequenceType;
    }
    /** 序列前缀位数;以哪些顺序号对应的入参作为开头，如有多个用逗号隔开。
     如：目录清单的主项顺序号前面是以行政区划和中央指导部门作为它是否同一类型的判断依据，如果是前缀相同，则递增，否则顺序号重新从0001开始计算。 */
    public String getSequencePrefix(){
        return this.sequencePrefix;
    }
    /** 序列前缀位数;以哪些顺序号对应的入参作为开头，如有多个用逗号隔开。
     如：目录清单的主项顺序号前面是以行政区划和中央指导部门作为它是否同一类型的判断依据，如果是前缀相同，则递增，否则顺序号重新从0001开始计算。 */
    public void setSequencePrefix(String sequencePrefix){
        this.sequencePrefix = sequencePrefix;
    }
    /** 通用类型;编号表提供一些基础类型供生成编号使用 */
    public String getCommType(){
        return this.commType;
    }
    /** 通用类型;编号表提供一些基础类型供生成编号使用 */
    public void setCommType(String commType){
        this.commType = commType;
    }
    /** 通用值;基础类型要使用的值 */
    public String getCommValue(){
        return this.commValue;
    }
    /** 通用值;基础类型要使用的值 */
    public void setCommValue(String commValue){
        this.commValue = commValue;
    }
    /** 顺序号;编号组成的顺序号 */
    public Integer getSerialNum(){
        return this.serialNum;
    }
    /** 顺序号;编号组成的顺序号 */
    public void setSerialNum(Integer serialNum){
        this.serialNum = serialNum;
    }
    /** 乐观锁 */
    public Integer getRevision(){
        return this.revision;
    }
    /** 乐观锁 */
    public void setRevision(Integer revision){
        this.revision = revision;
    }
    /** 创建人 */
    public String getCreatedBy(){
        return this.createdBy;
    }
    /** 创建人 */
    public void setCreatedBy(String createdBy){
        this.createdBy = createdBy;
    }
    /** 创建时间 */
    public Date getCreatedTime(){
        return this.createdTime;
    }
    /** 创建时间 */
    public void setCreatedTime(Date createdTime){
        this.createdTime = createdTime;
    }
    /** 更新人 */
    public String getUpdatedBy(){
        return this.updatedBy;
    }
    /** 更新人 */
    public void setUpdatedBy(String updatedBy){
        this.updatedBy = updatedBy;
    }
    /** 更新时间 */
    public Date getUpdatedTime(){
        return this.updatedTime;
    }
    /** 更新时间 */
    public void setUpdatedTime(Date updatedTime){
        this.updatedTime = updatedTime;
    }
}
