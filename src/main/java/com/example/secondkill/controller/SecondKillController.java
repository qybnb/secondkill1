package com.example.secondkill.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.secondkill.pojo.Order;
import com.example.secondkill.pojo.SecondkillOrder;
import com.example.secondkill.pojo.User;
import com.example.secondkill.service.IGoodsService;
import com.example.secondkill.service.IOrderService;
import com.example.secondkill.service.ISecondkillOrderService;
import com.example.secondkill.vo.GoodsVo;
import com.example.secondkill.vo.RespBeanEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/secondKill")
public class SecondKillController {
    @Autowired
    private IGoodsService goodsService;
    @Autowired
    private ISecondkillOrderService secondkillOrderService;
    @Autowired
    private IOrderService orderService;
    @RequestMapping("/doSecondKill")
    public String doSecondKill(Model model, User user, Long goodsId){
        if(user==null){
            return "after_login";
        }
        model.addAttribute("user",user);
        GoodsVo goods = goodsService.findGoodsVoByGoodsId(goodsId);
        if(goods.getStockCount()<1){
            model.addAttribute("errmsg", RespBeanEnum.EMPTY_STOCK.getMessage());
            return "secondKillFail";
        }
        SecondkillOrder secondkillOrder = secondkillOrderService.getOne(new QueryWrapper<SecondkillOrder>().eq("user_id", user.getId()).eq("goods_id", goodsId));
        if(secondkillOrder!=null){
            model.addAttribute("errmsg",RespBeanEnum.REPEAT_ERROR.getMessage());
            return "secondKillFail";
        }
        Order order = orderService.secondKill(user,goods);
        model.addAttribute("order",order);
        model.addAttribute("goods",goods);
        return "OrderDetail";

    }
}
