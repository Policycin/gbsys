package com.manage.gb.common;


import java.io.Serializable;

import com.manage.gb.constants.ResponseCode;

public class CommonRespInfoJson<T> implements Serializable {

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

    public CommonRespInfoJson() {

    }

    public CommonRespInfoJson(String resultCode, String resultMsg) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }

    public CommonRespInfoJson(String resultCode, String resultMsg, T resultData) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
        this.resultData = resultData;
    }

    /**
     * 响应成功
     *
     * @return
     */
    public static CommonRespInfoJson ok() {
        CommonRespInfoJson commonRespInfo = new CommonRespInfoJson();
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
    public static CommonRespInfoJson msg(String resultMsg) {
        CommonRespInfoJson commonRespInfo = new CommonRespInfoJson();
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
    public static CommonRespInfoJson resp(String resultCode, String resultMsg) {
        CommonRespInfoJson commonRespInfo = new CommonRespInfoJson();
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
    public static CommonRespInfoJson data(Object object) {
        CommonRespInfoJson commonRespInfo = new CommonRespInfoJson();
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
    public static CommonRespInfoJson createdOrUpdated(Object object) {
        return createdOrUpdated("ok", object);
    }

    /**
     * 创建或更新成功，自定义消息返回
     * @param resultMsg
     * @param object
     * @return
     */
    public static CommonRespInfoJson createdOrUpdated(String resultMsg, Object object) {
        CommonRespInfoJson commonRespInfo = new CommonRespInfoJson();

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
    public static CommonRespInfoJson from(CommonException exception) {
        CommonRespInfoJson commonRespInfo = new CommonRespInfoJson();
        commonRespInfo.setResultCode(exception.getCode());
        commonRespInfo.setResultMsg(exception.getMsg());

        return commonRespInfo;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public T getResultData() {
        return resultData;
    }

    public void setResultData(T resultData) {
        this.resultData = resultData;
    }
}
