package com.fuujiro.transport;

import com.fuujiro.serializer.CommonSerializer;

/**
 * Created by fzy at 17:24 on 2020/10/19.
 */
public interface RpcServer {

    void start();

    void setSerializer(CommonSerializer serializer);

    <T> void publishService(Object service, Class<T> serviceClass);

}