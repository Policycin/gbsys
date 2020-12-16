package com.manage.gb.file.service.controller;

import com.manage.gb.file.service.dto.FileInfoInDTO;
import com.manage.gb.file.service.dto.FileInfoOutDTO;
import com.manage.gb.file.service.entity.FileTypeConfigBO;
import com.manage.gb.file.service.response.CommonRespInfo;
import com.manage.gb.file.service.service.IFileUploadService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


/**
 * Created by xmkfzx on 2019/4/26.
 */
@Api(tags = "文件上传下载服务")
@RestController
@RequestMapping(value = "/generic")
public class FileUploadController {

    private static Logger logger = LoggerFactory.getLogger(FileUploadController.class);

    @Autowired
    private FileTypeConfigBO fileTypeConfigBO;

    @Autowired
    private IFileUploadService fileUploadService;


    @Value("${file.upload.path}")
    private String uploadFilePath;

    @Value("${image.upload}")
    private String imageUpload;


    @Value("${file.upload.ip}")
    private String showFilePath;

    @Value("${upload.file.type}")
    private String uploadFileType;

    /**
     * 文件上传下载
     * 遍历Http请求中的文件对象
     * 循环调用文件保存服务service
     *
     * @param fileInfo 文件定义信息（fileType 文件类型,rename 重命名,bizId业务编号）
     * @return FileInfoOutDTO 文件名和文件对应保存的具体路径
     */
    @ApiOperation(value = "文件上传", notes = "文件定义信息（fileType 文件类型,rename 重命名,bizId业务编号） 返回文件名和文件保存路径", httpMethod = "POST")
    @PostMapping(value = "/saveAccessory")
    public CommonRespInfo<List<FileInfoOutDTO>> fileUpload(@ModelAttribute FileInfoInDTO fileInfo) {
        logger.info("/file/saveAccessory : 文件上传");
        CommonRespInfo<List<FileInfoOutDTO>> commonRespInfo = new CommonRespInfo<List<FileInfoOutDTO>>();
        MultipartFile[] multiPartFiles = fileInfo.getFiles();
        if (multiPartFiles == null || multiPartFiles.length <= 0) {
            commonRespInfo.setResultCode("400");
            commonRespInfo.setResultMsg("没有选中的文件");
            return commonRespInfo;
        }
        String fileType = fileInfo.getFileType();
        String bizId = fileInfo.getBizId();
        String rename = fileInfo.getRename();
        if (null == fileType || "".equals(fileType)) {
            commonRespInfo.setResultCode("400");
            commonRespInfo.setResultMsg("文件类型参数没有传送");
            return commonRespInfo;
        }
        List<FileInfoOutDTO> fileList = new ArrayList<FileInfoOutDTO>();
        try {
            for (MultipartFile file : multiPartFiles) {
                FileInfoOutDTO dto = new FileInfoOutDTO();
                dto.setFileName(file.getOriginalFilename());
                String path = "";
                if (null != rename && !"".equals(rename)) {
                    path = fileUploadService.uploadFile(fileType, file, bizId, rename);
                } else {
                    path = fileUploadService.uploadFile(fileType, file, bizId);
                }
                dto.setFileName(file.getOriginalFilename());
                dto.setFilePath(path);
                fileList.add(dto);
                commonRespInfo.setResultCode("200");
                commonRespInfo.setResultMsg("文件上传成功");
            }
        } catch (Exception e) {
            commonRespInfo.setResultCode("500");
            commonRespInfo.setResultMsg("文件未能全部上传成功：" + e.toString());
        }
        commonRespInfo.setResultData(fileList);
        return commonRespInfo;
    }

    /**
     * 文件上传下载
     * 遍历Http请求中的文件对象
     * 循环调用文件保存服务service
     *
     * @param fileInfo 文件定义信息（fileType 文件类型,rename 重命名,bizId业务编号）
     * @return FileInfoOutDTO 文件名和文件对应保存的具体路径
     */
    @ApiOperation(value = "文件上传并返回展示url_单个文件", notes = "文件定义信息（fileType 文件类型,rename 重命名,bizId业务编号） 返回文件名和文件保存路径", httpMethod = "POST")
    @PostMapping(value = "/saveAccessoryAndShow")
    public CommonRespInfo<List<FileInfoOutDTO>> saveAccessoryAndShow(@ModelAttribute FileInfoInDTO fileInfo) {
        CommonRespInfo<List<FileInfoOutDTO>> commonRespInfo = new CommonRespInfo<List<FileInfoOutDTO>>();
        logger.info("/file/saveAccessoryAndShow : 文件上传并返回展示url");
        //文件类型设置默认的
        fileInfo.setFileType(uploadFileType);
        MultipartFile[] multiPartFiles = fileInfo.getFiles();
        if (multiPartFiles == null || multiPartFiles.length <= 0) {
            commonRespInfo.setResultCode("400");
            commonRespInfo.setResultMsg("没有选中的文件");
            return commonRespInfo;
        }
        String fileType = fileInfo.getFileType();
        if (null == fileType || "".equals(fileType)) {
            commonRespInfo.setResultCode("400");
            commonRespInfo.setResultMsg("文件类型参数没有传送");
            return commonRespInfo;
        }
        //重命名
        for (MultipartFile file : multiPartFiles) {
            String originalFilename = file.getOriginalFilename();
            String rename = UUID.randomUUID().toString().replaceAll("-", "") + originalFilename.substring(originalFilename.indexOf("."));
            fileInfo.setRename(rename);
        }
        //调用被装饰的方法
        commonRespInfo = fileUpload(fileInfo);
        for (FileInfoOutDTO outDTO : commonRespInfo.getResultData()) {
            //新增返回showUrl
            if(outDTO.getFilePath().startsWith(uploadFilePath)){
                outDTO.setShowUrl(showFilePath + imageUpload + outDTO.getFilePath().replace(uploadFilePath, ""));
            }
            if(outDTO.getFilePath().startsWith(fileTypeConfigBO.getRootDirectory())){
                outDTO.setShowUrl(showFilePath + imageUpload + outDTO.getFilePath().replace(fileTypeConfigBO.getRootDirectory(), ""));
            }
//            outDTO.setShowUrl(showFilePath + imageUpload + outDTO.getFilePath().replace(uploadFilePath, "").replace(fileTypeConfigBO.getRootDirectory(),""));
        }

        return commonRespInfo;
    }

    /**
     * 文件下载
     *
     * @param fileInfo 传递fileType和filePath下载文件
     * @return 文件对象
     */
    @ApiOperation(value = "文件下载", notes = "文件定义信息（filePath文件地址） 返回对象", httpMethod = "POST")
    @PostMapping(value = "/downloadAccessory")
    public ResponseEntity fileDownload(FileInfoInDTO fileInfo) {
        logger.info("/file/downloadAccessory : 文件下载");
        String filePath = fileInfo.getFilePath();
        Long len =  null;
        InputStreamResource inRes = null;
        HttpHeaders heads = new HttpHeaders();
        if (fileUploadService.isFilePathLegal(fileInfo.getFileType(), filePath)) {
            File file = new File(filePath);
            if (file.exists()) {
                try {
                    heads.add("Cache-Control", "no-cache,no-store,must-revalidate");
                    heads.add("Content-Disposition", "attachment;filename=" + URLEncoder.encode(file.getName(), "UTF-8"));
                    heads.add("Pragma", "no-cache");
                    heads.add("Expires", "0");
                    FileSystemResource f = new FileSystemResource(file);
                    inRes = new InputStreamResource(f.getInputStream());
                    len = f.contentLength();
                } catch (IOException e) {
                    logger.error("文件下载异常", e);
                    return ResponseEntity.badRequest().body(e.getMessage());
                }

            } else {
                return ResponseEntity.badRequest().body("文件不存在");
            }


        } else {
            return ResponseEntity.badRequest().body("仅能下载指定目录的的文件");
        }
        return ResponseEntity.ok().headers(heads).contentLength(len).
                contentType(MediaType.APPLICATION_OCTET_STREAM).body(inRes);

    }

    /**
     * 获取图片：用于获取用户上传的图片，不可用于下载文件
     *
     * @param fileInfo 文件信息
     * @return 文件流
     */
    @ApiOperation(value = "获取图片", notes = "文件定义信息（filePath文件地址） 返回对象", httpMethod = "POST")
    @PostMapping(value = "/downloadImg")
    public byte[] downloadImg(FileInfoInDTO fileInfo) throws IOException {
        logger.info("/file/downloadImg : 图片下载");
        byte[] result = null;
        String filePath = fileInfo.getFilePath();
        FileInputStream inputStream = null;
        try {
            if (fileUploadService.isFilePathLegal(fileInfo.getFileType(), filePath)) {
                File f = new File(filePath);
                if (f.exists() && f.isFile()) {
                    inputStream = new FileInputStream(f);
                    result = new byte[inputStream.available()];
                    inputStream.read(result, 0, inputStream.available());
                    return result;
                }
            } else {

            }
        } catch (IOException e) {
            logger.error("文件对象错误", e);
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
//            return result;
        }
        return result;
    }

    public FileTypeConfigBO getFileTypeConfigBO() {
        return fileTypeConfigBO;
    }

    public void setFileTypeConfigBO(FileTypeConfigBO fileTypeConfigBO) {
        this.fileTypeConfigBO = fileTypeConfigBO;
    }

    public IFileUploadService getFileUploadService() {
        return fileUploadService;
    }

    public void setFileUploadService(IFileUploadService fileUploadService) {
        this.fileUploadService = fileUploadService;
    }
}
