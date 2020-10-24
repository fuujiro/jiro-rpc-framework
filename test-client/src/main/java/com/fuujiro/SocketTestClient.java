package com.fuujiro;

import com.fuujiro.serializer.CommonSerializer;
import com.fuujiro.serializer.KryoSerializer;
import com.fuujiro.transport.RpcClientProxy;
import com.fuujiro.transport.socket.client.SocketClient;

/**
 * Created by fzy at 17:49 on 2020/10/19.
 */
public class SocketTestClient {

    public static void main(String[] args) {
        SocketClient client = new SocketClient(CommonSerializer.KRYO_SERIALIZER);
        RpcClientProxy proxy = new RpcClientProxy(client);
        HelloService helloService = proxy.getProxy(HelloService.class);
        HelloObject object = new HelloObject(12, "This is a message");
        String res = helloService.hello(object);
        System.out.println(res);
        ByeService byeService = proxy.getProxy(ByeService.class);
        System.out.println(byeService.bye("Netty"));
    }

}