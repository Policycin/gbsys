package com.manage.gb.common.handler;

import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.manage.gb.common.CommonException;
import com.manage.gb.common.CommonRespInfoJson;

/**
 * 全局异常统一处理类，返回错误码和错误信息给前端。
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private static org.slf4j.Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @ResponseBody
    @ExceptionHandler(value = {Exception.class, RuntimeException.class})
    public CommonRespInfoJson exceptionHandle(Exception e) {
    	CommonRespInfoJson commonRespInfo = new CommonRespInfoJson();
        //处理可以识别的异常，把异常码返回给前端。
        if (e instanceof CommonException) {
            String exceptionCode = ((CommonException) e).getCode();
            String exceptionMsg = ((CommonException) e).getMsg();
            commonRespInfo.setResultCode(exceptionCode);
            commonRespInfo.setResultMsg(exceptionMsg);
            logger.info("异常码:"+exceptionCode+",异常信息："+exceptionMsg);
        }else if(e instanceof MethodArgumentNotValidException){
            commonRespInfo.setResultCode("500");
            BindingResult bindingResult = ((MethodArgumentNotValidException) e).getBindingResult();
            String errorMesssage = "";
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                errorMesssage += fieldError.getDefaultMessage() + ",";
            }
            errorMesssage=errorMesssage.substring(0, errorMesssage.length() - 1);
            commonRespInfo.setResultMsg(errorMesssage);
            logger.info("方法参数非法异常:"+errorMesssage);
        }else {
            //不能识别的异常，就返回异常轨迹。
            commonRespInfo.setResultCode("500");
            commonRespInfo.setResultMsg(e.toString());
            logger.info("未识别异常，异常信息："+e.getMessage());
            //同时记录栈错误，定位代码位置
            logger.info(e.getMessage(),e);
        }
        return commonRespInfo;
    }

}
