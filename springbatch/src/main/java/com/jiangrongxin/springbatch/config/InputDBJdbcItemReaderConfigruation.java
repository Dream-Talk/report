package com.jiangrongxin.springbatch.config;

import com.jiangrongxin.springbatch.mapper.UserRowMapper;
import com.jiangrongxin.springbatch.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.batch.item.database.Order;
import org.springframework.batch.item.database.support.MySqlPagingQueryProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * @author admin
 * @create 2020-06-10 10:48
 * @desc 配置类
 **/
@Configuration
public class InputDBJdbcItemReaderConfigruation {

        @Autowired
        private JobBuilderFactory jobBuilderFactory;

        @Autowired
        private StepBuilderFactory stepBuilderFactory;

        @Autowired
        @Qualifier("DBJdbcWriterDemo")
        private ItemWriter<? super User> DBJbbcWriterDemo;

        @Autowired
        private DataSource dataSource;

        private static Logger logger = LogManager.getLogger(InputDBJdbcItemReaderConfigruation.class.getName());

        @Bean
        public Job DBJdbcItemReaderJob() {
            return jobBuilderFactory.get("DBJdbcItemReaderJob4")
                    .start(DBJdbcItemReaderJobStep())
                    .build();

        }

        @Bean
        public Step DBJdbcItemReaderJobStep() {
            return stepBuilderFactory.get("DBJdbcItemReaderJobStep4")
                    .<User, User>chunk(10)
                    .reader(DBJbbcReaderDemo())
                    .writer(DBJbbcWriterDemo)
                    .build();
        }

        @Bean
        @StepScope
        public JdbcPagingItemReader<User> DBJbbcReaderDemo() {
            JdbcPagingItemReader<User> reader = new JdbcPagingItemReader<>();
            reader.setDataSource(this.dataSource); // 设置数据源
            reader.setFetchSize(100); // 设置一次最大读取条数
            reader.setRowMapper(new UserRowMapper()); // 把数据库中的每条数据映射到User对中
            MySqlPagingQueryProvider queryProvider = new MySqlPagingQueryProvider();
            queryProvider.setSelectClause("cust_id,surname,gender,educa_des,mar_des,birthday,address"); // 设置查询的列
            queryProvider.setFromClause("from user"); // 设置要查询的表
            
            Map<String, Order> sortKeys = new HashMap<String, Order>();// 定义一个集合用于存放排序列
            sortKeys.put("cust_id", Order.ASCENDING);// 按照升序排序
            queryProvider.setSortKeys(sortKeys);
            reader.setQueryProvider(queryProvider);// 设置排序列
            return reader;
        }


}
