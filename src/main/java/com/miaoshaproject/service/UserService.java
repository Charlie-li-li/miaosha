package com.miaoshaproject.service;

import com.miaoshaproject.error.BusinessException;
import com.miaoshaproject.service.modal.UserModel;

/**
 * Description: miaosha
 * <p>
 * Created by lili on 2019/1/20 20:58
 */
public interface UserService {

     UserModel getUserById(Integer id);
     void register(UserModel userModel) throws BusinessException;
     UserModel validateLogin(String telphone,String encrptPassword) throws BusinessException;
}
