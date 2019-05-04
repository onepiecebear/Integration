package com.ebupt.dto;

/**
 * @Author: yushibo
 * @Date: 2019/5/3 0003 16:04
 * @Description:
 */

/**
 * 基本响应封装
 */
public class BaseResponse {

    /**
     * 响应码
     */
    private int code;

    /**
     * 响应消息
     */
    private String msg;

    protected BaseResponse() {}

    protected BaseResponse(CodeEnum code) {
        this.code = code.getCode();
        this.msg = code.getMsg();
    }

    public static BaseResponse ok(CodeEnum code) {
        return new BaseResponse(CodeEnum.OK);
    }

    public static BaseResponse error(CodeEnum code) {
        return new BaseResponse(CodeEnum.INTERNALSERVERERROR);
    }
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

