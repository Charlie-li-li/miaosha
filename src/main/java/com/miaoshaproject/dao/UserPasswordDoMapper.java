package com.miaoshaproject.dao;

import com.miaoshaproject.dataobject.UserPasswordDo;
import com.miaoshaproject.dataobject.UserPasswordDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserPasswordDoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_password
     *
     * @mbggenerated Fri Jan 18 17:44:10 CST 2019
     */
    int countByExample(UserPasswordDoExample example);



    UserPasswordDo selectByUserId(Integer userId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_password
     *
     * @mbggenerated Fri Jan 18 17:44:10 CST 2019
     */
    int deleteByExample(UserPasswordDoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_password
     *
     * @mbggenerated Fri Jan 18 17:44:10 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_password
     *
     * @mbggenerated Fri Jan 18 17:44:10 CST 2019
     */
    int insert(UserPasswordDo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_password
     *
     * @mbggenerated Fri Jan 18 17:44:10 CST 2019
     */
    int insertSelective(UserPasswordDo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_password
     *
     * @mbggenerated Fri Jan 18 17:44:10 CST 2019
     */
    List<UserPasswordDo> selectByExample(UserPasswordDoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_password
     *
     * @mbggenerated Fri Jan 18 17:44:10 CST 2019
     */
    UserPasswordDo selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_password
     *
     * @mbggenerated Fri Jan 18 17:44:10 CST 2019
     */
    int updateByExampleSelective(@Param("record") UserPasswordDo record, @Param("example") UserPasswordDoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_password
     *
     * @mbggenerated Fri Jan 18 17:44:10 CST 2019
     */
    int updateByExample(@Param("record") UserPasswordDo record, @Param("example") UserPasswordDoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_password
     *
     * @mbggenerated Fri Jan 18 17:44:10 CST 2019
     */
    int updateByPrimaryKeySelective(UserPasswordDo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_password
     *
     * @mbggenerated Fri Jan 18 17:44:10 CST 2019
     */
    int updateByPrimaryKey(UserPasswordDo record);
}