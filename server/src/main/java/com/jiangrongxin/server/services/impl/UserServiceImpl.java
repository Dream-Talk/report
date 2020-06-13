package com.jiangrongxin.server.services.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.jiangrongxin.server.mapper.IUserMapper;
import com.jiangrongxin.server.model.User;
import com.jiangrongxin.server.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author admin
 * @create 2020-06-10 20:46
 * @desc 客户关系service实现类
 **/
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserMapper userDao;
    @Override
    public List<User> findAll(String order) throws Exception {
        System.out.println(order);
        return userDao.findAll(order);
    }

    @Override
    public User findById(int id) throws Exception {
        return userDao.findById(id);
    }

    @Override
    public List<User> findByName(String name) throws Exception {
        name = "%"+name+"%";
        return userDao.findByName(name);
    }

    @Override
    public Page<User> getUsersByPage() throws Exception {
        return userDao.getUsersByPage();
    }


}
