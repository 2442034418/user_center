package com.wood.usercenter.common;

import com.wood.usercenter.exception.BusinessException;

/**
 * 返回工具类
 *
 * @author wood
 */
public class ResultUtils {
    /**
     * 成功
     *
     * @param data
     * @return
     * @param <T>
     */
    public static <T> BaseResponse<T> success(T data) {
        return new BaseResponse<>(0, "ok", "", data);
    }

    /**
     * 失败
     *
     * @param errorCode
     * @return
     */
    public static BaseResponse error (ErrorCode errorCode) {
        return new BaseResponse<>(errorCode);
    }

    public static BaseResponse error (int code, String message, String description) {
        return new BaseResponse<>(code, message, description, null);
    }
}
