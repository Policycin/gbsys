package com.manage.gb.file.service.dto;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by xmkfzx on 2019/4/26.
 */
public class FileInfoInDTO  {

    private String fileType;//文件类型

    private String rename;//重命名文件

    private String bizId;//业务编号

    private String filePath;//文件路径

    private MultipartFile[] files;

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getRename() {
        return rename;
    }

    public void setRename(String rename) {
        this.rename = rename;
    }

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public MultipartFile[] getFiles() {
        return files;
    }

    public void setFiles(MultipartFile[] files) {
        this.files = files;
    }
}
