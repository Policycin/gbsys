package com.manage.gb.file.service.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xmkfzx on 2019/4/28.
 * 文件保存路径配置信息
 */
@Component
@ConfigurationProperties(prefix="com.ccbft.govern.common.doc")
@PropertySource("classpath:fileTypes.properties")
public class FileTypeConfigBO {

    //文件类型对应的保存子目录
    private Map<String,String> fileTypes = new HashMap<String,String>();

    //文件保存的根目录
    private String rootDirectory ;

    /**
     * 根据文件类型获取文件类型保存的子目录
     * @param fileType 文件类型，定义在fileTypes.properties中
     * @return 子目录
     */
    public String getSubPath(String fileType){
        return fileTypes.get(fileType);
    }

    /**
     * 获取文件上传的根目录
     * （因为最好上传的目录统一，因此只配置了一个，有需要不同的话联系guopx改造）
     * @return
     */
    public String getRootPath(){
        return this.rootDirectory;
    }

    public Map<String, String> getFileTypes() {
        return fileTypes;
    }

    public void setFileTypes(Map<String, String> fileTypes) {
        this.fileTypes = fileTypes;
    }

    public String getRootDirectory() {
        return rootDirectory;
    }

    public void setRootDirectory(String rootDirectory) {
        this.rootDirectory = rootDirectory;
    }
}
