package com.manage.gb.file.service.dto;

import lombok.Data;

/**
 * Created by xmkfzx on 2019/4/26.
 */
@Data
public class FileInfoOutDTO {
    private String fileName ;
    private String filePath ;
    private String showUrl;

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
}
