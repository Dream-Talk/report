package com.jiangrongxin.springbatch.mapper;


import com.jiangrongxin.springbatch.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author admin
 * @create 2020-06-10 10:56
 * @desc 实体类mapper
 **/
public class UserRowMapper implements RowMapper<User> {

    /**
     * rs一条结果集，rowNum代表当前行
     */
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new User(rs.getInt("cust_id")
                ,rs.getString("String surname")
                ,(char)rs.getInt("gender")
                ,rs.getString("educa_des")
                ,rs.getString("mar_des")
                ,rs.getInt("birthday")
                ,rs.getString("address"));
    }

}


