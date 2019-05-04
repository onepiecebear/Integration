package com.ebupt.dto;

/**
 * @Author: yushibo
 * @Date: 2019/5/3 0003 16:04
 * @Description:
 */

import java.util.ArrayList;

/**
 * 响应数据结构封装
 */
public class DataResponse<T> extends BaseResponse {

        private T data;

        private DataResponse() {}

        private DataResponse(CodeEnum code, T data) {
            super(code);
            this.data = data;
        }

        public DataResponse(T data) {
            this.data = data;
        }

    public static <T> DataResponse<T> ok(T data) {
            return new DataResponse<T>(data);
        }
    public static <T> DataResponse<T> error(T data) {
        return new DataResponse<T>(data);
    }




    public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }



}

