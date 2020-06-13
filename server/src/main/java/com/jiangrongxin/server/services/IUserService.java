package com.jiangrongxin.server.services;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.jiangrongxin.server.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author admin
 * @create 2020-06-10 20:45
 * @desc 客户信息Service
 **/

public interface IUserService {

    /**
     * 查询所有客户信息
     */
    List<User>  findAll(String order)throws Exception;
    /**
    * 根据ID查询客户信息
    */
    User findById(int id) throws Exception;

    /**
     *根据姓名查询客户信息
     */
    List<User> findByName(String name) throws Exception;

    /**
     *使用pagehelper进行物理分页
     */
    Page<User> getUsersByPage() throws Exception;
}
