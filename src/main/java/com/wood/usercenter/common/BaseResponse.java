package com.wood.usercenter.common;

import lombok.Data;

import java.io.Serializable;

/**
 * 通用返回类
 *
 * @param <T>
 * @author wood
 */
@Data
public class BaseResponse<T> implements Serializable {
    private int code;

    private String msg;

    private String description;

    private T data;

    public BaseResponse(int code, String msg, String description, T data) {
        this.code = code;
        this.msg = msg;
        this.description = description;
        this.data = data;
    }

    public BaseResponse(int code, T data) {
        this(code, "", "", data);
    }

    public BaseResponse(ErrorCode errorCode) {
        this(errorCode.getCode(), errorCode.getMessage(), errorCode.getDescription(), null);
    }

    public BaseResponse(ErrorCode errorCode, String description) {
        this(errorCode.getCode(), errorCode.getMessage(), description, null);
    }
}
