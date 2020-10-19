package com.fuujiro.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by fzy at 15:29 on 2020/10/16.
 */

// 客户端向服务器端提出request，需要4个参数：
//    接口的名字，和方法的名字，但是由于方法重载的缘故，我们还需要这个方法的所有参数的类型，最后，客户端调用时，还需要传递参数的实际值。

@Data
@AllArgsConstructor
public class RpcRequest implements Serializable {

    public RpcRequest() {}

    // 待调用接口名称
    private String interfaceName;
    // 待调用方法名称
    private String methodName;
    // 待调用方法参数
    private Object[] parameters;
    // 调用方法的参数类型
    private Class<?>[] paramTypes;
}
