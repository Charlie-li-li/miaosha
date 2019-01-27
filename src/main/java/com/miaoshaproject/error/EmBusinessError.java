package com.miaoshaproject.error;

import com.miaoshaproject.response.CommonReturnType;

/**
 * Description: miaosha
 * <p>
 * Created by lili on 2019/1/26 19:37
 */
public enum EmBusinessError implements CommonError {
    //通用错误类型
    PARAMETER_VALIDATION_ERROR(10001,"参数不合法"),
    UNKNOWN_ERROR(10002,"未知错误"),

    USR_NOT_EXIT(20001,"用户不存在")

    ;


    private EmBusinessError(int errCode,String errMsg){
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    private int errCode;
    private String errMsg;

    @Override
    public int getErrCode() {
        return this.errCode;
    }

    @Override
    public String getErrMsg() {
        return this.errMsg;
    }

    @Override
    public CommonError setErrMsg(String errMsg) {
         this.errMsg = errMsg;
        return this;
    }}
