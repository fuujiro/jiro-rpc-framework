package com.fuujiro.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by fzy at 3:55 PM on 2020/9/16.
 */
@AllArgsConstructor
@Getter
public enum ResponseCode {

    SUCCESS(200,"调用方法成功"),
    FAIL(500,"调用方法失败"),
    NOT_FOUND_METHOD(500,"未找到指定方法"),
    NOT_FOUND_CLASS(500,"未找到指定类");

    private final int code;
    private final String message;

}

