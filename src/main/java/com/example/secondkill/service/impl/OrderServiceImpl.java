package com.example.secondkill.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.secondkill.mapper.OrderMapper;
import com.example.secondkill.pojo.Order;
import com.example.secondkill.pojo.SecondkillGoods;
import com.example.secondkill.pojo.SecondkillOrder;
import com.example.secondkill.pojo.User;
import com.example.secondkill.service.IOrderService;
import com.example.secondkill.service.ISecondkillGoodsService;
import com.example.secondkill.service.ISecondkillOrderService;
import com.example.secondkill.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhoubin
 * @since 2022-06-01
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {
    @Autowired
    private ISecondkillGoodsService secondkillGoodsService;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private ISecondkillOrderService secondkillOrderService;
    @Override
    public Order secondKill(User user, GoodsVo goods) {
        SecondkillGoods secondkillGoods = secondkillGoodsService.getOne(new QueryWrapper<SecondkillGoods>().eq("goods_id", goods.getId()));
        secondkillGoods.setStockCount(secondkillGoods.getStockCount()-1);
        secondkillGoodsService.updateById(secondkillGoods);
        Order order=new Order();
        order.setUserId(user.getId());
        order.setGoodsId(goods.getId());
        order.setDeliveryAddId(0L);
        order.setGoodsName(goods.getGoodsName());
        order.setGoodsCount(1);
        order.setGoodsPrice(secondkillGoods.getSecondkillPrice());
        order.setOrderChannel(1);
        order.setStatus(0);
        order.setCreateDate(new Date());
        orderMapper.insert(order);

        SecondkillOrder secondkillOrder =new SecondkillOrder();

        secondkillOrder.setGoodsId(goods.getId());
        secondkillOrder.setUserId(user.getId());
        secondkillOrder.setOrderId(order.getId());
        secondkillOrderService.save(secondkillOrder);
        return order;




    }
}
