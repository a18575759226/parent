package com.xmg.shop.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
@Getter@Setter
public class OrderInfo implements Serializable {

    public static final  int  UNCONFIRMED = 0 ;//0为未确认
    public static final  int  CONFIRMED = 1 ;//1已经确认
    public static final  int  FINISHED = 2 ;//2为已收货

    private Long id;

    private String orderSn;//订单编号

    private Long userId;//订单编号

    private int orderStatus;//订单状态：0为未确认，1为已确认，2为已完成

    private int shippingStatus;//订单物流状态：0为未发货，1为已发货，2为已收货

    private int payStatus;//订单支付状态：0为为支付，2为已支付

    private String consignee;//收货人名字

    private String mobile;//收货人联系电话

    private String country;//收货国家

    private String province;//收货省份

    private String city;//收货城市

    private String district;//收货地区

    private String address;//收货具体地址

    private String zipcode;//收货的邮政编码

    private BigDecimal orderAmount;//订单总价

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ordertime;//下单时间

    /**
     *处理前台状态数据的显示
     * @return
     */
    public String getOrderStatusDisplay(){

        switch (orderStatus){
            case UNCONFIRMED :
                return "未确认";
            case CONFIRMED :
                return "已经确认";
            case FINISHED :
                return "已收货";
                default:
                    return "";
        }
    }
}