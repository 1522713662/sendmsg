package com.gree.scada.entity.common;

/**
 * @program: WeChat
 * @CladdName ResultEntity.java
 * @description: 返回
 * @author: 260340
 * @create: 2020-04-30 13:56
 **/
public class ResultEntity<T> {

    private Integer code;
    private String msg;
    private T data;

    public static ResultEntity success() {
        ResultEntity result = new ResultEntity();
        result.setCode(ResultCode.SUCCESS.getCode());
        result.setMsg(ResultCode.SUCCESS.getDescription());
        return result;
    }

    public static <T> ResultEntity success(T data) {
        ResultEntity<T> result = new ResultEntity();
        result.setCode(ResultCode.SUCCESS.getCode());
        result.setMsg(ResultCode.SUCCESS.getDescription());
        result.setData(data);
        return result;
    }

    public static <T> ResultEntity faild(ResultCode code) {
        ResultEntity<T> result = new ResultEntity();
        result.setCode(code.getCode());
        result.setMsg(code.getDescription());
        return result;
    }

    public static <T> ResultEntity faild(ResultCode code, T data) {
        ResultEntity<T> result = new ResultEntity();
        result.setCode(code.getCode());
        result.setMsg(code.getDescription());
        result.setData(data);
        return result;
    }

    public static <T> ResultEntity faild(ResultCode code,String msg){
        ResultEntity<T> result=new ResultEntity<>();
        result.setCode(code.getCode());
        result.setMsg(msg);
        return result;
    }

    public static ResultEntity redirect(String url) {
        ResultEntity<String> result = new ResultEntity<>();
        result.setCode(ResultCode.REDIRECT.getCode());
        result.setMsg(ResultCode.REDIRECT.getDescription());
        result.setData(url);
        return result;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}