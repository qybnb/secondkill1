package com.example.secondkill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.secondkill.pojo.User;
import com.example.secondkill.vo.LoginVo;
import com.example.secondkill.vo.RespBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhoubin
 * @since 2022-05-30
 */
public interface IUserService extends IService<User> {

    RespBean doLogin(LoginVo loginVo, HttpServletRequest request, HttpServletResponse response);
    User getUserByCookie(String userTicker,HttpServletRequest request,HttpServletResponse response);

}
