package com.jiangrongxin.server.mapper;

import com.github.pagehelper.Page;
import com.jiangrongxin.server.model.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


import java.util.List;

/**
 * @author admin
 * @create 2020-06-10 20:48
 * @desc 客户关系Dao
 **/
@Repository
public interface IUserMapper {

    @Select("select * from user order by cust_id ${order}")
    List<User> findAll(@Param("order")String order) throws Exception;

    @Select("select * from user where cust_id = #{id}")
    User findById(int id) throws Exception;

    @Select("select * from user where surname like #{name}")
    List<User> findByName(String name) throws Exception;

    @Select("select * from user")
    Page<User> getUsersByPage() throws Exception;
}
