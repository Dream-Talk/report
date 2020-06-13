package com.jiangrongxin.server.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jiangrongxin.server.model.User;
import com.jiangrongxin.server.services.IUserService;
import com.jiangrongxin.server.util.ResultUtils;
import io.swagger.annotations.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author admin
 * @create 2020-06-10 18:59
 * @desc 客户信息
 **/
@Api(description ="客户信息管理API")
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private IUserService userService;

    private static final Logger logger = LogManager.getLogger(UserController.class.getName());

    private ResultUtils result;

    @ApiOperation(value = "查询所有的客户信息并排序0升序 1降序默认升序",httpMethod = "GET")
    @ApiImplicitParam(name = "order", value = "排序标志", required = false, dataType = "int")
    @GetMapping("/user/order/{order}")
    public String findAll(@PathVariable(value = "order",required = false) int order){
        String tag=(order==1)?"desc":"asc";
        String content = "";
        try {
            List<User> users = userService.findAll(tag);
            content =  JSONObject.toJSONString(result.buildSuccess(users,0));
        } catch (Exception e) {
            e.printStackTrace();
            content = JSONObject.toJSONString(result.buildError(e.getMessage(),-1));
            logger.error(e.getMessage());
        }
        return content;
    }

    @ApiOperation(value = "根据ID查询客户信息",httpMethod = "GET")
    @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "int")
    @GetMapping("/user/id/{id}")
    public String findById(@PathVariable(value = "id",required = true) int id){
        String content = "";
        try {
            User user= userService.findById(id);
            content =  JSONObject.toJSONString(result.buildSuccess(user,0));
        } catch (Exception e) {
            e.printStackTrace();
            content = JSONObject.toJSONString(result.buildError(e.getMessage(),-1));
            logger.error(e.getMessage());
        }
        return content;
    }

    @ApiOperation(value = "根据姓名查询客户信息",httpMethod = "GET")
    @ApiImplicitParam(name = "name", value = "用户姓名", required = true, dataType = "string")
    @GetMapping("/user/name/{name}")
    public String findByName(@PathVariable(value = "name",required = true) String name){
        String content = "";
        try {
          List<User> users = userService.findByName(name);
            content =  JSONObject.toJSONString(result.buildSuccess(users,0));
        } catch (Exception e) {
            e.printStackTrace();
            content = JSONObject.toJSONString(result.buildError(e.getMessage(),-1));
            logger.error(e.getMessage());
        }
        return content;
    }

    @ApiOperation(value = "分页查询",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页数", required = true, dataType = "int"),
            @ApiImplicitParam(name = "size", value = "每页大小", required = true, dataType = "int")
    })
    @GetMapping("/user/page/{page}/size/{size}")
    public String findByName(@PathVariable(value = "page",required = true) int page,
                              @PathVariable(value = "size",required = true) int size){
        String content = "";
        try {
            PageHelper.startPage(page,size);
            PageInfo<User> pageInfo = new PageInfo<>(userService.getUsersByPage());
            content =  JSONObject.toJSONString(result.buildSuccess(pageInfo.getList(),0));

        } catch (Exception e) {
            logger.error(e.getMessage());
            content =  JSONObject.toJSONString(result.buildError(e.getMessage(),0));
            e.printStackTrace();
        }
        return content;
    }

}
