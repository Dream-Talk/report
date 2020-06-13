package com.jiangrongxin.server.test;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jiangrongxin.server.controller.UserController;
import com.jiangrongxin.server.model.User;
import com.jiangrongxin.server.services.IUserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author admin
 * @create 2020-06-10 15:05
 * @desc 客户信息serviece测试
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private IUserService userService;

    private static final Logger logger = LogManager.getLogger(UserServiceTest.class.getName());

    /**
     * 查询所有客户信息  asc升序  desc降序
     */
    @Test
    public void findAll(){
        try {
            System.out.println(userService.findAll("asc"));
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
    }

    /**
     * 根据ID查询客户信息
     */
    @Test
    public void findById(){
        try {
            System.out.println(userService.findById(1));
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
    }
    /**
     *根据姓名查询客户信息
     */
    @Test
    public void findByName(){
        try {
            System.out.println(userService.findByName("四"));
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
    }
    /**
     *使用pagehelper进行物理分页
     */
    @Test
    public void getUsersByPage(){
        try {
            PageHelper.startPage(1,2);
            PageInfo<User> pageInfo = new PageInfo<>(userService.getUsersByPage());
            System.out.println(pageInfo.getList());
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
    }





}
