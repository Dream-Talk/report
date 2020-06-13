package com.jiangrongxin.server.services;

import com.github.pagehelper.Page;
import com.jiangrongxin.server.model.Transcation;
import com.jiangrongxin.server.model.User;

import java.util.List;

/**
 * @author admin
 * @create 2020-06-10 11:45
 * @desc 交易信息表接口
 **/
public interface ITranscationService {
    /**
     * 查询所有交易信息
     */
    List<Transcation> findAll(String order)throws Exception;
    /**
     * 根据ID查询交易信息
     */
     Transcation findById(int id) throws Exception;

    /**
     *根据用户ID查询交易信息
     */
    List<Transcation> findByUserId(int cust_id) throws Exception;

    /**
     *使用pagehelper进行物理分页
     */
    Page<Transcation> getTranByPage() throws Exception;
}
