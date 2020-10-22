package com.fuujiro;

import com.fuujiro.serializer.CommonSerializer;
import com.fuujiro.serializer.ProtobufSerializer;
import com.fuujiro.transport.RpcClient;
import com.fuujiro.transport.RpcClientProxy;
import com.fuujiro.transport.netty.client.NettyClient;

/**
 * Created by fzy at 17:46 on 2020/10/19.
 */
public class NettyTestClient {

    public static void main(String[] args) {
        RpcClient client = new NettyClient(CommonSerializer.PROTOBUF_SERIALIZER);
        RpcClientProxy rpcClientProxy = new RpcClientProxy(client);
        HelloService helloService = rpcClientProxy.getProxy(HelloService.class);
        HelloObject object = new HelloObject(12, "This is a message");
        String res = helloService.hello(object);
        System.out.println(res);

    }

}
