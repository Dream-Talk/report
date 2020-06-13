package com.jiangrongxin.server.test;

import com.jiangrongxin.server.controller.UserController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

/**
 * @author admin
 * @create 2020-06-10 19:24
 * @desc 日志记录测试类
 **/
public class LogTest {

    private static Logger logger = LogManager.getLogger(UserController.class.getName());

    @Test
    public void LogTest(){
        logger.error("error");
        logger.warn("warn");
        logger.info("info");
        logger.info("debug");
        logger.trace("trace");

    }
}
