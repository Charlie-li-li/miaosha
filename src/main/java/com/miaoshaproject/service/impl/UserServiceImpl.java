package com.miaoshaproject.service.impl;

import com.miaoshaproject.dao.UserDoMapper;
import com.miaoshaproject.dao.UserPasswordDoMapper;
import com.miaoshaproject.dataobject.UserDo;
import com.miaoshaproject.dataobject.UserPasswordDo;
import com.miaoshaproject.error.BusinessException;
import com.miaoshaproject.error.EmBusinessError;
import com.miaoshaproject.service.UserService;
import com.miaoshaproject.service.modal.UserModel;
import org.apache.commons.lang3.StringUtils;
import org.omg.PortableInterceptor.ORBInitInfoPackage.DuplicateName;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.validation.Validator;
import java.sql.BatchUpdateException;

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

    @Override
    @Transactional
    public void register(UserModel userModel) throws BusinessException {
        if(userModel == null){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }


        if(StringUtils.isNotEmpty(userModel.getName())
                || userModel.getGender()==null
                ||userModel.getAge()==null
                ||StringUtils.isNotEmpty(userModel.getTelphone())
        ) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        UserDo userDo = convertFromModel(userModel);
        try {
            userDoMapper.insertSelective(userDo);
        }catch (DuplicateKeyException ex){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR,"手机号已注册");
        }

        UserPasswordDo userPasswordDo = convertPasswordFromModel(userModel);
        userPasswordDoMapper.insertSelective(userPasswordDo);
        return;
    }

    @Override
    public UserModel validateLogin(String telphone, String encrptPassword) throws BusinessException {
        UserDo userDo = userDoMapper.selectByTelphone(telphone);
        if(userDo == null){
            throw new BusinessException(EmBusinessError.USR_LOGIN_FAIL);
        }
        UserPasswordDo userPasswordDo = userPasswordDoMapper.selectByUserId(userDo.getId());
        UserModel userModel = convertFromDataObject(userDo,userPasswordDo);

        if(!StringUtils.equals(encrptPassword,userModel.getEncrptPassword())){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }


        return userModel;
    }


    private UserPasswordDo convertPasswordFromModel(UserModel userModel){
        if(userModel == null){
            return  null;
        }
        UserPasswordDo userPasswordDo = new UserPasswordDo();
        userPasswordDo.setEncrptPassword(userModel.getEncrptPassword());
        userPasswordDo.setUserId(userModel.getId());
        return  userPasswordDo;
    }

    private UserDo convertFromModel(UserModel userModel){
        if(userModel == null){
            return null;
        }
        UserDo userDo = new UserDo();
        BeanUtils.copyProperties(userModel,userDo);
        return  userDo;
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
