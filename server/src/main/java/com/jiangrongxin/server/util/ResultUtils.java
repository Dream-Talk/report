package com.jiangrongxin.server.util;

import lombok.Data;

import java.io.Serializable;

/**
 * @author admin
 * @create 2020-06-13 5:33
 * @desc 返回数据接口的对象封装 包含数据，状态码，描述
 **/

@Data
public class ResultUtils implements Serializable {

        private static final long serialVersionUID = 1L;

        private Integer code; // 状态码 0 表示成功，1表示处理中，-1表示失败
        private Object data; // 数据
        private String msg;// 描述

        public ResultUtils() {
        }

        public ResultUtils(Integer code, Object data, String msg) {
            this.code = code;
            this.data = data;
            this.msg = msg;
        }


        // 失败，传入描述信息,状态码
        public static ResultUtils buildError(String msg, Integer code) {
            return new ResultUtils(code, null, msg);
        }


        // 成功，传入数据,及状态码
        public static ResultUtils buildSuccess(Object data, int code) {
            return new ResultUtils(code, data, "成功");
        }

}
