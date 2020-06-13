package com.jiangrongxin.springbatch.writer;


import com.jiangrongxin.springbatch.model.User;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author admin
 * @create 2020-06-10 10:53
 * @desc
 **/

    @Component("DBJdbcWriterDemo")
    public class DBJdbcWriterDemo implements ItemWriter<User> {

        @Override
        public void write(List<? extends User> items) throws Exception {
            for(User user:items) {
                System.out.println(user);
            }
        }

    }

