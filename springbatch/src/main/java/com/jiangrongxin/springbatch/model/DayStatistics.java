package com.jiangrongxin.springbatch.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author admin
 * @create 2020-06-10 13:07
 * @desc 日汇统计实体类
 **/
@Data
@ApiModel(description = "日汇明细表")
public class DayStatistics {
    @ApiModelProperty(value = "索引项")
    private int s_index;
    @ApiModelProperty(value = "客户号")
    private int cust_id;
    @ApiModelProperty(value = "更新时间")
    private LocalDateTime update_time;
    @ApiModelProperty(value = "日期")
    private LocalDate trans_date;
    @ApiModelProperty(value = "客户姓名")
    private String surname;
    @ApiModelProperty(value = "最大单笔交易金额")
    private BigDecimal tran_max_amt;
    @ApiModelProperty(value = "当天还款总金额")
    private BigDecimal pay_amt;
    @ApiModelProperty(value = "当天消费笔数")
    private int tran_cnt;
    @ApiModelProperty(value = "当天还款笔数")
    private int pay_cnt;
    @ApiModelProperty(value = "当天交易总金额")
    private BigDecimal tran_amt;
}
