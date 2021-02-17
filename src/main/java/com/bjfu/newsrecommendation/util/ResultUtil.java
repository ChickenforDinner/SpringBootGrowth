package com.bjfu.newsrecommendation.util;

import java.io.Serializable;

public class ResultUtil<T> implements Serializable {
    /**
     * 返回是否成功
     */
    private Boolean success;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 返回数据内容
     */
    private T data;

    public ResultUtil() {
    }

    public ResultUtil(Boolean success, String msg, T data) {
        this.success = success;
        this.msg = msg;
        this.data = data;
    }
    
    public static <T> ResultUtil success(T data){
        return new ResultUtil(true , "请求成功" , data);
    }


    public static <T> ResultUtil success(String msg ,T data){
        return new ResultUtil(true , msg , data);
    }


    public static ResultUtil fail(String msg){
        return new ResultUtil(true , msg , null);
    }
    
    public static <T> ResultUtil fail(String msg ,T data){
        return new ResultUtil(false , msg , data);
    }
}