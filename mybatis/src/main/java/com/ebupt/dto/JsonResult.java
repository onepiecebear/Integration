package com.ebupt.dto;

/**
 * @Author: yushibo
 * @Date: 2019/5/6 13:58
 * @Description: 200：表示成功
 * 				  500：表示错误，错误信息在msg字段中
 * 				  501：bean验证错误，不管多少个错误都以map形式返回
 * 				  502：拦截器拦截到用户token出错
 * 				  555：异常抛出信息
 */
public class JsonResult {

    // 响应业务状态
    private Integer status;

    // 响应消息
    private String msg;

    // 响应中的数据
    private Object data;

    private String vacancy;	// 暂不使用

    public JsonResult(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }
    public JsonResult(Object data) {
        this.status = 200;
        this.msg = "OK";
        this.data = data;
    }

    public static JsonResult custom(Integer status, String msg, Object data) {
        return new JsonResult(status, msg, data);
    }

    public static JsonResult ok(Object data) {
        return new JsonResult(data);
    }

    public static JsonResult ok() {
        return new JsonResult(null);
    }

    public static JsonResult errorMsg(String msg) {
        return new JsonResult(500, msg, null);
    }

    public static JsonResult errorMap(Object data) {
        return new JsonResult(501, "error", data);
    }

    public static JsonResult errorTokenMsg(String msg) {
        return new JsonResult(502, msg, null);
    }

    public static JsonResult errorException(String msg) {
        return new JsonResult(555, msg, null);
    }

}
