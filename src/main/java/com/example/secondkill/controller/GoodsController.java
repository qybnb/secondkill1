package com.example.secondkill.controller;

import com.example.secondkill.pojo.User;
import com.example.secondkill.service.IGoodsService;
import com.example.secondkill.service.IUserService;
import com.example.secondkill.vo.GoodsVo;
import freemarker.template.utility.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

//跳转到商品列表页面
@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private IUserService userService;
    @Autowired
    private IGoodsService goodsService;
    @RequestMapping("/toList")
    public String toList( Model model,User user){

//        if(StringUtils.isEmpty(ticket)){
//            return "login";
//        }
//        User user=(User) userService.getUserByCookie(ticket,request,response);
//        if(user==null){
//            return "login";
//        }
//
        model.addAttribute("user",user);
        model.addAttribute("goodsList",goodsService.findGoodsVo());
        return "goodsList";
    }
    @RequestMapping("/toDetail/{goodsId}")
    public String toDetail(Model model,User user,@PathVariable Long goodsId){
        model.addAttribute("user",user);
        GoodsVo goodsVo=goodsService.findGoodsVoByGoodsId(goodsId);
        Date startdate=goodsVo.getStartDate();
        Date enddate=goodsVo.getEndDate();
        Date nowdate=new Date();
        int secondKillStatus=0;
        int remainseconds=0;
        if (nowdate.before((startdate))){
                remainseconds=(int) ((startdate.getTime()-nowdate.getTime())/1000);

        }else if(nowdate.after(enddate)){
            secondKillStatus=2;
            remainseconds=-1;
        }else{
            secondKillStatus=1;
            remainseconds=0;
        }
        model.addAttribute("remainseconds",remainseconds);
        model.addAttribute("secondKillStatus",secondKillStatus);
        model.addAttribute("goods",goodsVo);
        return "goodsDetail";
    }

}
