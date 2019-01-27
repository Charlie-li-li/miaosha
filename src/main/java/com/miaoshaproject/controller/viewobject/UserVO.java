package com.miaoshaproject.controller.viewobject;

/**
 * Description: miaosha
 * <p>
 * Created by lili on 2019/1/20 22:01
 */
public class UserVO {
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getGender() {
        return gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setGender(Byte gender) {
        this.gender = gender;
    }


    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    private  Integer id;
    private  String name;
    private  Byte gender;
    private  Integer age;
    private  String telphone;
}
