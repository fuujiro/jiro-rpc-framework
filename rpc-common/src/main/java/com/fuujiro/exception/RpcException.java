package com.fuujiro.exception;

import com.fuujiro.enumeration.RpcError;

/**
 * Created by fzy at 20:48 on 2020/10/14.
 */
public class RpcException extends RuntimeException {

    public RpcException(RpcError error, String detail) {
        super(error.getMessage() + ":" + detail);
    }

    public RpcException(String message, Throwable cause) {
        super(message, cause);
    }

    public RpcException(RpcError error) {
        super(error.getMessage());
    }
}
