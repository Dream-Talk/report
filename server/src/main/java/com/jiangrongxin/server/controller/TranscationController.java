package com.jiangrongxin.server.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jiangrongxin.server.model.Transcation;
import com.jiangrongxin.server.services.ITranscationService;
import com.jiangrongxin.server.util.ResultUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author admin
 * @create 2020-06-10 18:58
 * @desc 交易明细
 **/
@Api(description ="交易信息API")
@RestController
@RequestMapping("/api/transcations")
public class TranscationController {

    @Autowired
    private ITranscationService transcation;
    @Autowired
    private static Logger logger = LogManager.getLogger(TranscationController.class.getName());

    private ResultUtils result;


    @ApiOperation(value = "查询所有的交易信息并排序0升序 1降序默认升序",httpMethod = "GET")
    @ApiImplicitParam(name = "order", value = "排序标志", required = false, dataType = "int")
    @GetMapping("/tran/order/{order}")
    public String findAll(@PathVariable(value = "order",required = false) int order){
        String tag=(order==1)?"desc":"asc";
        String content = "";
        try {
            List<Transcation> trans = transcation.findAll(tag);
            content =  JSONObject.toJSONString(result.buildSuccess(trans,0));
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            content = JSONObject.toJSONString(result.buildError(e.getMessage(),-1));
        }
        return content;
    }

    @ApiOperation(value = "根据交易ID查询交易信息",httpMethod = "GET")
    @ApiImplicitParam(name = "id", value = "交易ID", required = true, dataType = "int")
    @GetMapping("/tran/id/{id}")
    public String findById(@PathVariable(value = "id",required = true) int id){
        String content = "";
        try {
            Transcation tran = transcation.findById(id);
            content =  JSONObject.toJSONString(result.buildSuccess(tran,0));
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            content = JSONObject.toJSONString(result.buildError(e.getMessage(),-1));
        }
        return content;
    }

    @ApiOperation(value = "根据客户ID查询交易信息",httpMethod = "GET")
    @ApiImplicitParam(name = "userid", value = "客户号", required = true, dataType = "int")
    @GetMapping("/tran/userid/{userid}")
    public String findByName(@PathVariable(value = "userid",required = true) int userid){
        String content = "";
        try {
            List<Transcation> trans = transcation.findByUserId(userid);
            content =  JSONObject.toJSONString(result.buildSuccess(trans,0));
        } catch (Exception e) {
            content = JSONObject.toJSONString(result.buildError(e.getMessage(),-1));
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        return content;
    }

    @ApiOperation(value = "分页查询",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页数", required = true, dataType = "int"),
            @ApiImplicitParam(name = "size", value = "每页大小", required = true, dataType = "int")
    })
    @GetMapping("/tran/page/{page}/size/{size}")
    public String findByName(@PathVariable(value = "page",required = true) int page,
                             @PathVariable(value = "size",required = true) int size){
        String content = "";
        try {
            PageHelper.startPage(page,size);
            PageInfo<Transcation> pageInfo = new PageInfo<>(transcation.getTranByPage());
            content =  JSONObject.toJSONString(result.buildSuccess(pageInfo.getList(),0));

        } catch (Exception e) {
            content = JSONObject.toJSONString(result.buildError(e.getMessage(),-1));
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        return content;
    }


}
