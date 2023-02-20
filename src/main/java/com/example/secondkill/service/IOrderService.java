package com.example.secondkill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.secondkill.mapper.GoodsMapper;
import com.example.secondkill.pojo.Order;
import com.example.secondkill.pojo.User;
import com.example.secondkill.vo.GoodsVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhoubin
 * @since 2022-06-01
 */
public interface IOrderService extends IService<Order> {
    Order secondKill(User user, GoodsVo goods);

}
