package edu.xidian.boot.common;

import lombok.Data;


@Data
public class BaseResponse<T> {

    private String msg;

    private T data;

    public BaseResponse<T> success(T data) {
        BaseResponse<T> baseResponse = new BaseResponse<>();
        baseResponse.setData(data);
        baseResponse.setMsg("success");
        return baseResponse;
    }

    public BaseResponse<T> success() {
        BaseResponse<T> baseResponse = new BaseResponse<>();
        baseResponse.setMsg("success");
        return baseResponse;
    }

    public BaseResponse<T> fail(String msg) {
        BaseResponse<T> baseResponse = new BaseResponse<>();
        baseResponse.setMsg(msg);
        return baseResponse;
    }


}
