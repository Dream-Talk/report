package com.jiangrongxin.springbatch.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author admin
 * @create 2020-06-10 13:07
 * @desc 交易明细实体类
 **/
@Data
@AllArgsConstructor
@ApiModel(description = "交易明细表")
public class Transcation {
    @ApiModelProperty(value = "交易ID")
    private  int trans_id;
    @ApiModelProperty(value = "客户ID")
    private  int cust_id;
    @ApiModelProperty(value = "账号号")
    private  String account;
    @ApiModelProperty(value = "卡号")
    private  String  card_nbr;
    @ApiModelProperty(value = "交易流水号")
    private  int tranno;
    @ApiModelProperty(value = "账单月")
    private  int month_nbr;
    @ApiModelProperty(value = "交易金额")
    private  BigDecimal bill;
    @ApiModelProperty(value = "交易类型")
    private  String trans_type;
    @ApiModelProperty(value = "交易日期")
    private  LocalDateTime txn_datetime;
}
