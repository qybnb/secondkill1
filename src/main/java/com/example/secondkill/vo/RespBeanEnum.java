package com.example.secondkill.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
@Getter
@ToString
@AllArgsConstructor
public enum RespBeanEnum {
    //通用
    SUCCESS(200,"SUCCESS"),
    ERROR(500,"ERROR"),
    //login
    LOGIN_ERROR(500210,"用户名或密码错误"),
    MOBILE_ERROR(500211,"手机号不正确"),
    BIND_ERROR(500212,"参数校验异常"),
    //秒杀
    EMPTY_STOCK(500500,"库存不足"),
    REPEAT_ERROR(500501,"该商品不可重复抢购"),
    ;
    private final Integer code;
    private final String message;

}
