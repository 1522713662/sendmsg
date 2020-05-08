package com.gree.scada.entity.common;

/**
 * @program: WeChat
 * @CladdName ResultCode.java
 * @description: 结果标识
 * @author: 260340
 * @create: 2020-04-30 13:54
 **/
public enum ResultCode {

    /**
     * 响应成功
     */
    SUCCESS(0, "响应成功"),

    /**
     * 请求异常
     */
    REQUEST_FAILD(1, "请求异常"),

    /**
     * Session失效
     */
    SESSION_FAILD(2, "SESSION失效"),

    /**
     * 权限异常
     */
    PERMISSION_FAILD(3, "权限异常"),

    /**
     * 操作异常
     */
    OPERATE_FAILD(10, "操作异常"),

    /**
     * 页面跳转
     */
    REDIRECT(11, "页面跳转"),

    /**
     * 内部异常
     */
    INTERNAL_FAILD(-1, "内部异常"),

    /**
     * 未知异常
     */
    UNKNOW_FAILD(100, "未知异常");

    private Integer code;
    private String description;

    ResultCode(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}