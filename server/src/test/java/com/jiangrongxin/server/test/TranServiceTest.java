package com.jiangrongxin.server.test;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jiangrongxin.server.mapper.ITranMapper;
import com.jiangrongxin.server.model.Transcation;
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
 * @create 2020-06-10 15:24
 * @desc 交易服务Service测试
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class TranServiceTest {
    @Autowired
    private ITranMapper tranMapper;

    private static final Logger logger = LogManager.getLogger(TranServiceTest.class.getName());
    /**
     * 查询所有订单号 asc升序 desc降序
     */
    @Test
    public void findAll(){
        try {
            System.out.println(tranMapper.findAll("asc"));
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
    }

    /**
     * 根据交易ID查询交易信息
     */
    @Test
    public void findById(){
        try {
            System.out.println(tranMapper.findById(1));
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
    }

    /**
     *根据用户ID查询交易信息
     */

    @Test
    public void findByUserId(){
        try {
           System.out.println(tranMapper.findByUserId(1));
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
    }

    /**
     *使用pagehelper进行物理分页查询交易订单
     */
    @Test
    public void getTranByPage(){
        try {
            PageHelper.startPage(1,2);
            PageInfo<Transcation> pageInfo = new PageInfo<>(tranMapper.getTranByPage());
            System.out.println(pageInfo.getList());
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
    }
}
