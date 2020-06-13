package com.jiangrongxin.server.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author admin
 * @create 2020-06-10 12:56
 * @desc 客户关系实体类
 **/
@Data
@ApiModel(description = "客户详细信息")
public class User {
    @ApiModelProperty(value = "客户ID")
    private int cust_id;
    @ApiModelProperty(value = "客户名")
    private  String surname;
    @ApiModelProperty(value = "性别")
    private  char gender;
    @ApiModelProperty(value = "教育状况")
    private  String educa_des;
    @ApiModelProperty(value = "婚姻状况")
    private  String mar_des;
    @ApiModelProperty(value = "生日")
    private  int birthday;
    @ApiModelProperty(value = "住址")
    private  String address;
}
