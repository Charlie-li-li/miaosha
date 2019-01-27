package com.miaoshaproject.controller;

import com.miaoshaproject.controller.viewobject.UserVO;
import com.miaoshaproject.error.BusinessException;
import com.miaoshaproject.error.EmBusinessError;
import com.miaoshaproject.response.CommonReturnType;
import com.miaoshaproject.service.UserService;
import com.miaoshaproject.service.modal.UserModel;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@Controller
@RequestMapping("/user")
@CrossOrigin

public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @Autowired
    private HttpServletRequest httpServletRequest;

    @RequestMapping(value = "/getopt",method = {RequestMethod.POST})
    @ResponseBody
    public CommonReturnType getOtp(@RequestParam(name="telphone")String telphone){
        Random random = new Random();
        int randomInt =  random.nextInt(89999);
        randomInt += 10000;
        String optCode = String.valueOf(randomInt);

        httpServletRequest.getSession().setAttribute(telphone,optCode);

        System.out.println("telphone="+telphone + "&optCode="+optCode);

        return  CommonReturnType.create(null);
    }

    @RequestMapping("/get")
    @ResponseBody
    public CommonReturnType getUser(@RequestParam(name="id") Integer id) throws BusinessException {

        UserModel userModel = userService.getUserById(id);

        if(userModel==null){
            throw new BusinessException(EmBusinessError.USR_NOT_EXIT);
//            userModel.setEncrptPassword("123");
        }

        UserVO userVO =  convertFromModel(userModel);

        return  CommonReturnType.create(userVO);

    }

    private  UserVO convertFromModel(UserModel userModel){
        if(userModel == null){
            return null;
        }
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(userModel,userVO);
        return  userVO;
    }

}








