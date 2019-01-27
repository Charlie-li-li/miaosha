package com.miaoshaproject.dao;

import com.miaoshaproject.dataobject.UserDo;
import com.miaoshaproject.dataobject.UserDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserDoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbggenerated Fri Jan 18 17:44:10 CST 2019
     */
    int countByExample(UserDoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbggenerated Fri Jan 18 17:44:10 CST 2019
     */
    int deleteByExample(UserDoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbggenerated Fri Jan 18 17:44:10 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbggenerated Fri Jan 18 17:44:10 CST 2019
     */
    int insert(UserDo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbggenerated Fri Jan 18 17:44:10 CST 2019
     */
    int insertSelective(UserDo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbggenerated Fri Jan 18 17:44:10 CST 2019
     */
    List<UserDo> selectByExample(UserDoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbggenerated Fri Jan 18 17:44:10 CST 2019
     */
    UserDo selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbggenerated Fri Jan 18 17:44:10 CST 2019
     */
    int updateByExampleSelective(@Param("record") UserDo record, @Param("example") UserDoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbggenerated Fri Jan 18 17:44:10 CST 2019
     */
    int updateByExample(@Param("record") UserDo record, @Param("example") UserDoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbggenerated Fri Jan 18 17:44:10 CST 2019
     */
    int updateByPrimaryKeySelective(UserDo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbggenerated Fri Jan 18 17:44:10 CST 2019
     */
    int updateByPrimaryKey(UserDo record);
}