package entity;

import enumeration.ResponseCode;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by fzy at 17:05 on 2020/10/16.
 */

// 服务器端向客户端返回信息

@Data
public class RpcResponse<T> implements Serializable {
    // 响应状态码
    private Integer statusCode;
    // 响应状态补充信息
    private String message;
    // 响应数据
    private T data;

    public static <T> RpcResponse<T> success(T data) {
        RpcResponse<T> response = new RpcResponse<>();
        response.setStatusCode(ResponseCode.SUCCESS.getCode());
        response.setData(data);
        return response;
    }
    public static <T> RpcResponse<T> fail(ResponseCode code) {
        RpcResponse<T> response = new RpcResponse<>();
        response.setStatusCode(code.getCode());
        response.setMessage(code.getMessage());
        return response;
    }
}
