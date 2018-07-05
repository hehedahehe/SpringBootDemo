package com.cesuokanc.feign;

import lombok.Data;

import java.io.Serializable;

/**
 * @author liruibo
 * @date 2018/7/5
 */
@Data
public class RestResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer code = 0;
    private String message = "success";
    private T data;

    public static <W> RestResult<W> getSuccessRest(W data) {
        RestResult<W> restResult = new RestResult<>();
        restResult.setData(data);
        return restResult;
    }
}
