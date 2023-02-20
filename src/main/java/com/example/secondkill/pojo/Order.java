package com.example.secondkill.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhoubin
 * @since 2022-06-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_order")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 商品ID
     */
    private Long goodsId;

    /**
     * 收货地址id
     */
    private Long deliveryAddId;

    /**
     * 冗余的商品名称
     */
    private String goodsName;

    /**
     * 商品数量
     */
    private Integer goodsCount;

    /**
     * 商品单价
     */
    private BigDecimal goodsPrice;

    /**
     * 1pc 2android 3ios
     */
    private Integer orderChannel;

    /**
     * 订单状态：0、新建未支付 1、已支付 2、已发货 3、已收货 4、已退款 5、已完成
     */
    private Integer status;

    /**
     * 订单创建的时间
     */
    private Date createDate;

    /**
     * 支付的时间
     */
    private Date payDate;


}
