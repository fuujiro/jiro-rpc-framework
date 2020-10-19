package com.fuujiro;

import com.fuujiro.entity.RpcRequest;

/**
 * Created by fzy at 17:24 on 2020/10/19.
 */
public interface RpcClient {

    Object sendRequest(RpcRequest rpcRequest);

}


