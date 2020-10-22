package com.fuujiro.transport;

import com.fuujiro.serializer.CommonSerializer;

/**
 * Created by fzy at 17:24 on 2020/10/19.
 */
public interface RpcServer {

    int DEFAULT_SERIALIZER = CommonSerializer.KRYO_SERIALIZER;

    void start();

    <T> void publishService(T service, Class<T> serviceClass);

}