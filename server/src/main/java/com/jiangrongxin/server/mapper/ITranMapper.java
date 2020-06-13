package com.jiangrongxin.server.mapper;

import com.github.pagehelper.Page;
import com.jiangrongxin.server.model.Transcation;
import com.jiangrongxin.server.model.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author admin
 * @create 2020-06-10 12:16
 * @desc 交易信息Mapper
 **/
public interface ITranMapper {
    @Select("select * from transcation order by trans_id ${order}")
    List<Transcation> findAll(@Param("order")String order) throws Exception;

    @Select("select * from transcation where trans_id = #{id}")
    Transcation findById(int id) throws Exception;

    @Select("select * from transcation where cust_id = #{cust_id}")
    List<Transcation> findByUserId(int cust_id) throws Exception;

    @Select("select * from transcation")
    Page<Transcation> getTranByPage() throws Exception;
}
