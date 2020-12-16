package com.manage.gb.file.service.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by xmkfzx on 2019/4/29.
 */
public interface IFileUploadService {

    /**
     * 根据文件类型上传文件(文件名使用上传文件本身的名称)
     * 根据fileType 读取fileTypes.properties（可以放置到配置中心）里配置的文件类型对应的保存路径
     * 读取配置文件中rootDirectory配置的根目录
     * 通过跟目录拼接上fileTypes配置的路径形成完整的路径
     * 根据目录创建的需要，处理路径中定义的YYYYMMDD为日期
     * @param fileType 预先定义好的文件类型
     * @param multipartFile Http请求的文件
     * @return 上传文件保存的全路径
     */
    public String uploadFile(String fileType, MultipartFile multipartFile,String bizId);

    /**
     * 根据文件类型上传文件(文件名使用上传文件本身的名称)
     * 根据fileType 读取fileTypes.properties（可以放置到配置中心）里配置的文件类型对应的保存路径
     * 读取配置文件中rootDirectory配置的根目录
     * 通过跟目录拼接上fileTypes配置的路径形成完整的路径
     * 根据目录创建的需要，处理路径中定义的YYYYMMDD为日期
     * @param fileType 预先定义好的文件类型
     * @param multipartFile Http请求的文件
     * @param rename 将文件重命名的名称
     * @return 上传文件保存的全路径
     */
    public String uploadFile(String fileType, MultipartFile multipartFile,String bizId, String rename);


    /**
     * 判断下载的文件路径是否合法
     * @param fileType 文件类型
     * @param filePath 下载路径
     * @return
     */
    public boolean isFilePathLegal(String fileType,String filePath);



}
