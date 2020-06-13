package com.jiangrongxin.server.services.impl;

import com.github.pagehelper.Page;
import com.jiangrongxin.server.mapper.ITranMapper;
import com.jiangrongxin.server.model.Transcation;
import com.jiangrongxin.server.services.ITranscationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author admin
 * @create 2020-06-10 11:52
 * @desc 交易信息表
 **/
@Service
public class TranscationServiceImpl implements ITranscationService {

     @Autowired
    private ITranMapper tranMapper;

    @Override
    public List<Transcation> findAll(String order) throws Exception {
        return tranMapper.findAll(order);
    }

    @Override
    public Transcation findById(int id) throws Exception {
        return tranMapper.findById(id);
    }

    @Override
    public List<Transcation> findByUserId(int cust_id) throws Exception {
        return tranMapper.findByUserId(cust_id);
    }

    @Override
    public Page<Transcation> getTranByPage() throws Exception {
        return tranMapper.getTranByPage();
    }
}
