package com.miaoshaproject.response;

/**
 * Description: miaosha
 * <p>
 * Created by lili on 2019/1/26 19:20
 */
public class CommonReturnType {
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static CommonReturnType create(Object result){
        return  CommonReturnType.create(result,"success");
    }

    public static CommonReturnType create(Object result,String status){
        CommonReturnType type = new CommonReturnType();
        type.setStatus(status);
        type.setData(result);
        return  type;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    private Object data;
}
