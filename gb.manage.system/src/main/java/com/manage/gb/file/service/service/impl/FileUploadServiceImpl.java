package com.manage.gb.file.service.service.impl;


import com.manage.gb.file.service.entity.FileTypeConfigBO;
import com.manage.gb.file.service.service.IFileUploadService;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by xmkfzx on 2019/4/29.
 */
@Service
@Primary
public class FileUploadServiceImpl implements IFileUploadService {

    @Autowired
    private FileTypeConfigBO fileTypeConfigBO;

    //日期格式化工具
    private SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
    private SimpleDateFormat yyyyMM = new SimpleDateFormat("yyyyMM");
    private SimpleDateFormat yyyy = new SimpleDateFormat("yyyy");


    @Override
    public String uploadFile(String fileType, MultipartFile multipartFile,String bizId) {
        checkReqParam(fileType, multipartFile);
        //根据定义配置信息获取根目录和子目录配置
        String savePath = getPath(fileType,bizId);
        // 如果附件文件夹不存在，则创建
        File directory = new File(savePath);
        if (!directory.exists()) directory.mkdirs();
        String fullPath = savePath+multipartFile.getOriginalFilename();
        FileOutputStream fos = null;
        try{
            fos = new FileOutputStream(fullPath);
            fos.write(multipartFile.getBytes());
        }catch(IOException e ){
            throw new RuntimeException(e);
        }finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return fullPath;
    }

    @Override
    public String uploadFile(String fileType, MultipartFile multipartFile,String bizId, String rename) {
        checkReqParam(fileType, multipartFile);
        if(isNullOrBlank(rename)){
            //异常还没有统一定义，暂时使用普通异常
            throw new RuntimeException("重命名文件名不能为空");
        }
        String savePath = getPath(fileType,bizId);
        // 如果附件文件夹不存在，则创建
        File directory = new File(savePath);
        if (!directory.exists()) directory.mkdirs();
        String fullPath = savePath+rename;
        FileOutputStream fos = null;
        try{
            fos = new FileOutputStream(fullPath);
            fos.write(multipartFile.getBytes());
        }catch(IOException e ){
            throw new RuntimeException(e);
        }finally {
            if (fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return fullPath;
    }

    /**
     * 校验下载路径是否合法， 1 判断路径是在我们配置的根目录下就合法
     *                     2 路径中不允许出现 .. 或 .
     * @param fileType 文件类型
     * @param filePath 下载路径
     * @return
     */
    @Override
    public boolean isFilePathLegal(String fileType, String filePath) {
        if(null != filePath && !"".equals(filePath)){
            if(filePath.startsWith(fileTypeConfigBO.getRootDirectory())){
                String[] pathPart = filePath.split(File.separator);
                if (!ArrayUtils.contains(pathPart, "..") && !ArrayUtils.contains(pathPart, ".")){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 获取文件保存路径（若服务器上不存在该路径则创建）
     * @param fileType
     */
    private String getPath(String fileType,String bizId){
        //根据定义配置信息获取根目录和子目录配置
        String rootPath = fileTypeConfigBO.getRootPath();
        String subPath  = fileTypeConfigBO.getSubPath(fileType);
        String savaPath = rootPath+replaceBizId(replaceDate(subPath),bizId);//拼接时替换业务编号和日期
        File file = new File(savaPath);
        if(!file.exists()){
            file.mkdirs();
        }
        return savaPath;
    }

    /**
     * 入参检查
     * @param fileType 文件类型
     * @param multipartFile 文件对象
     */
    private void checkReqParam(String fileType, MultipartFile multipartFile){
        //参数校验
        if(isNullOrBlank(fileType)){
            //异常还没有统一定义，暂时使用普通异常
            throw new RuntimeException("文件类型不能为空");
        }
        if(multipartFile==null){
            //异常还没有统一定义，暂时使用普通异常
            throw new RuntimeException("文件对象不能为空");
        }
        //根据定义配置信息获取根目录和子目录配置
        String rootPath = fileTypeConfigBO.getRootPath();
        if(rootPath==null){
            //异常还没有统一定义，暂时使用普通异常
            throw new RuntimeException("获取不到文件上传根目录");
        }
        String subPath  = fileTypeConfigBO.getSubPath(fileType);
        if(subPath==null){
            //异常还没有统一定义，暂时使用普通异常
            throw new RuntimeException("获取不到文件上传子目录");
        }
    }

    private boolean isNullOrBlank(String s){
        if(StringUtils.isBlank(s)||StringUtils.isEmpty(s)){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 为文件类型的子目录层级替换日期配置
     * @param subPath 文件类型对应的子目录
     * @return 替换完成的子目录
     */
    private String replaceDate(String subPath){
        String curYYYYMMDD = yyyyMMdd.format(new Date());
        String curYYYYMM = yyyyMM.format(new Date());
        String curYYYY = yyyy.format(new Date());
        return subPath.replaceAll("@@YYYYMMDD@@",curYYYYMMDD).
                replaceAll("@@YYYYMM@@", curYYYYMM).replaceAll("@@YYYY@@",curYYYY);
    }

    /**
     * 为子目录层级替换业务编号配置
     * @param bizId
     * @return
     */
    private String replaceBizId(String subPath,String bizId){
        return subPath.replaceAll("@@bizId@@",bizId);
    }

    public FileTypeConfigBO getFileTypeConfigBO() {
        return fileTypeConfigBO;
    }

    public void setFileTypeConfigBO(FileTypeConfigBO fileTypeConfigBO) {
        this.fileTypeConfigBO = fileTypeConfigBO;
    }
}
