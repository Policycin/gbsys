package com.manage.gb.model;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 附件表
 * </p>
 *
 * @author zxd
 * @since 2020-12-16
 */
public class Attachments implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    /**
     * 关联内容的id
     */
    private String associatedId;

    /**
     * 附件类型
     */
    private String fileType;

    /**
     * 附件重名名称
     */
    private String reFileName;

    /**
     * 附件名称
     */
    private String fileName;

    /**
     * 附件路径
     */
    private String filePath;

    /**
     * 附件大小，kb
     */
    private String fileSize;

    /**
     * 上传时间
     */
    private LocalDateTime createDate;

    /**
     * 下载次数
     */
    private Long loadCount;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAssociatedId() {
        return associatedId;
    }

    public void setAssociatedId(String associatedId) {
        this.associatedId = associatedId;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getReFileName() {
        return reFileName;
    }

    public void setReFileName(String reFileName) {
        this.reFileName = reFileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public Long getLoadCount() {
        return loadCount;
    }

    public void setLoadCount(Long loadCount) {
        this.loadCount = loadCount;
    }

    @Override
    public String toString() {
        return "Attachments{" +
        "id=" + id +
        ", associatedId=" + associatedId +
        ", fileType=" + fileType +
        ", reFileName=" + reFileName +
        ", fileName=" + fileName +
        ", filePath=" + filePath +
        ", fileSize=" + fileSize +
        ", createDate=" + createDate +
        ", loadCount=" + loadCount +
        "}";
    }
}
