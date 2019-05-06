package com.ebupt.dto;

/**
 * @Author: yushibo
 * @Date: 2019/5/3 0003 16:03
 * @Description:
 */


/**
 * 响应状态码和说明
 */
public enum CodeEnum {
    OK(200, "请求成功"),

    CREATED(201, "成功请求并创建了新的资源"),
    //异步
    ACCEPTED(202, "已经接受请求，但未处理完成"),
    //删除
    NOCONTENT(204, "无内容"),
    RESETCONTENT(205, "重置内容"),

    BADREQUEST	(400, "请求参数有误"),
    //鉴权
    UNAUTHORIZED(401, "未经授权访问"),
    FORBIDDEN(403, "服务器拒绝处理"),
    //错误
    INTERNALSERVERERROR(500, "服务器错误");




    /**
     * 响应状态码
     */
    private final int code;

    /**
     * 响应提示
     */
    private final String msg;

    CodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
