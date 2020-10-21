package com.fuujiro.transport;

import com.fuujiro.entity.RpcRequest;
import com.fuujiro.serializer.CommonSerializer;

/**
 * Created by fzy at 17:24 on 2020/10/19.
 */
public interface RpcClient {

    Object sendRequest(RpcRequest rpcRequest);

    void setSerializer(CommonSerializer serializer);

}



