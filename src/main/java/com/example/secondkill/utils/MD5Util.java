package com.example.secondkill.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

@Component
public class MD5Util {
    public static  String md5(String src){
        return DigestUtils.md5Hex(src);
    }
    private static final   String salt="1a2b3c4d";
    public static String inputPassToFromPass(String inputPass){
        //混淆
        String str=""+salt.charAt(0)+salt.charAt(2)+inputPass+salt.charAt(5)+salt.charAt(4);
        //MD5加密
        return md5(str);
    }
    public static String fromPassToDBPass(String fromPass,String salt){
        //根据数据库随机生成的DBsalt二次加密
        String str=""+salt.charAt(0)+salt.charAt(2)+fromPass+salt.charAt(5)+salt.charAt(4);
        return md5(str);
    }
    public  static  String inputPassToDBPass(String inputPass,String saltDB){
        String fromPass=inputPassToFromPass(inputPass);
        String DBPass=fromPassToDBPass(fromPass,saltDB);
        return DBPass;

    }

    public static void main(String[] args) {
        System.out.println(inputPassToFromPass("123456"));
        System.out.println(fromPassToDBPass(inputPassToFromPass("123456"),"1a2b3c4d"));
        System.out.println(inputPassToDBPass("123456","1a2b3c4d"));
    }

}
