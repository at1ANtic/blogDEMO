package com.example.utils;


import org.apache.shiro.crypto.hash.Md5Hash;

public class Md5Util {

    // 基于shiro的MD5加密，加密结果为32位小写
    public static String md5(String str) {
        return new Md5Hash(str).toString();
    }
}
