package com.miaoshaproject.error;

/**
 * Description: miaosha
 * <p>
 * Created by lili on 2019/1/26 19:34
 */
public interface CommonError {
     int getErrCode();
     String getErrMsg();
     CommonError setErrMsg(String errMsg);
}
