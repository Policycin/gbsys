package com.manage.gb.file.service.response;


import com.manage.gb.common.CommonException;
import com.manage.gb.constants.ResponseCode;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * 通用响应结构
 *
 * 请尽量使用提供的静态方法来构建返回
 *
 * 实在不符的情况，可以使用构造方法
 *
 * @param <T>
 */
@XmlRootElement
public class CommonRespInfo<T> implements Serializable {

    private static final long serialVersionUID = -852957744292972831L;

    private String resultCode;

    private String resultMsg;

    private T resultData;

    @Override
    public String toString() {
        return "CommonRespInfo{" +
                "resultCode='" + resultCode + '\'' +
                ", resultMsg='" + resultMsg + '\'' +
                ", resultData=" + resultData +
                '}';
    }

    public CommonRespInfo() {

    }

    public CommonRespInfo(String resultCode, String resultMsg) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }

    public CommonRespInfo(String resultCode, String resultMsg, T resultData) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
        this.resultData = resultData;
    }

    /**
     * 响应成功
     *
     * @return
     */
    public static CommonRespInfo ok() {
        CommonRespInfo commonRespInfo = new CommonRespInfo();
        commonRespInfo.setResultCode(ResponseCode.OK);
        commonRespInfo.setResultMsg("ok");
        return commonRespInfo;
    }

    /**
     * 响应成功，自定义消息
     *
     * @param resultMsg
     * @return
     */
    public static CommonRespInfo msg(String resultMsg) {
        CommonRespInfo commonRespInfo = new CommonRespInfo();
        commonRespInfo.setResultCode(ResponseCode.OK);
        commonRespInfo.setResultMsg(resultMsg);
        return commonRespInfo;
    }

    /**
     * 自定义响应码与消息
     *
     * @param resultCode
     * @param resultMsg
     * @return
     */
    public static CommonRespInfo resp(String resultCode, String resultMsg) {
        CommonRespInfo commonRespInfo = new CommonRespInfo();
        commonRespInfo.setResultCode(resultCode);
        commonRespInfo.setResultMsg(resultMsg);
        return commonRespInfo;
    }

    /**
     * 带数据响应成功
     *
     * 用于查询结果
     * @param object
     * @return
     */
    public static CommonRespInfo data(Object object) {
        CommonRespInfo commonRespInfo = new CommonRespInfo();
        commonRespInfo.setResultCode(ResponseCode.OK);
        commonRespInfo.setResultMsg("ok");
        commonRespInfo.setResultData(object);
        return commonRespInfo;
    }

    /**
     * 创建或更新成功
     *
     * 用于创建与更新
     * @param object
     * @return
     */
    public static CommonRespInfo createdOrUpdated(Object object) {
        return createdOrUpdated("ok", object);
    }

    /**
     * 创建或更新成功，自定义消息返回
     * @param resultMsg
     * @param object
     * @return
     */
    public static CommonRespInfo createdOrUpdated(String resultMsg, Object object) {
        CommonRespInfo commonRespInfo = new CommonRespInfo();

        commonRespInfo.setResultCode(ResponseCode.CREATE_OR_MODIFIED);
        commonRespInfo.setResultMsg(resultMsg);
        commonRespInfo.setResultData(object);

        return commonRespInfo;
    }

    /**
     * 从通用异常构建响应体
     * @param exception
     * @return
     */
    public static CommonRespInfo from(CommonException exception) {
        CommonRespInfo commonRespInfo = new CommonRespInfo();
        commonRespInfo.setResultCode(exception.getCode());
        commonRespInfo.setResultMsg(exception.getMsg());

        return commonRespInfo;
    }

    @XmlElement
    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    @XmlElement
    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    @XmlElement
    public T getResultData() {
        return resultData;
    }

    public void setResultData(T resultData) {
        this.resultData = resultData;
    }
}
