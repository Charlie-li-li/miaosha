package com.miaoshaproject.service.impl;

import com.miaoshaproject.dao.UserDoMapper;
import com.miaoshaproject.dao.UserPasswordDoMapper;
import com.miaoshaproject.dataobject.UserDo;
import com.miaoshaproject.dataobject.UserPasswordDo;
import com.miaoshaproject.service.UserService;
import com.miaoshaproject.service.modal.UserModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description: miaosha
 * <p>
 * Created by lili on 2019/1/20 21:00
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDoMapper userDoMapper;

    @Autowired
    private UserPasswordDoMapper userPasswordDoMapper;

    @Override
    public UserModel getUserById(Integer id) {
        UserDo userDO =  userDoMapper.selectByPrimaryKey(id);
        if(userDO == null){
            return  null;
        }

        UserPasswordDo userPasswordDo = userPasswordDoMapper.selectByUserId(id);

        return  convertFromDataObject(userDO,userPasswordDo);

    }

    private  UserModel convertFromDataObject(UserDo userDO, UserPasswordDo userPassWordDo){
        if(userDO == null){
            return  null;
        }
        UserModel userModel = new UserModel();
        BeanUtils.copyProperties(userDO,userModel);
        if(userPassWordDo != null){
            userModel.setEncrptPassword(userPassWordDo.getEncrptPassword());
        }
        return  userModel;
    }
}
