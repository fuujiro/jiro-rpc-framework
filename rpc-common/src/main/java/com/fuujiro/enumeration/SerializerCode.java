package com.fuujiro.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by fzy at 17:22 on 2020/10/19.
 */
@AllArgsConstructor
@Getter
public enum SerializerCode {

    KRYO(0),
    JSON(1),
    HESSIAN(2),
    PROTOBUF(3);

    private final int code;

}