package com.manage.gb.file.service.dto;


import java.io.Serializable;
import java.util.Date;

/**
 * Created by qiuhuansheng on 2019/5/8 0008.
 */
public class RcSerialNumberDto implements Serializable {
    /** 编号 */
    private Integer id ;
    /** 序号类型 */
    private String numberType ;
    /** 前缀 */
    private String prefix ;
    /** 当前序号值 */
    private String numberValue ;
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

    /** 编号 */
    public Integer getId(){
        return this.id;
    }
    /** 编号 */
    public void setId(Integer id){
        this.id = id;
    }
    /** 序号类型 */
    public String getNumberType(){
        return this.numberType;
    }
    /** 序号类型 */
    public void setNumberType(String numberType){
        this.numberType = numberType;
    }
    /** 前缀 */
    public String getPrefix(){
        return this.prefix;
    }
    /** 前缀 */
    public void setPrefix(String prefix){
        this.prefix = prefix;
    }
    /** 当前序号值 */
    public String getNumberValue(){
        return this.numberValue;
    }
    /** 当前序号值 */
    public void setNumberValue(String numberValue){
        this.numberValue = numberValue;
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
