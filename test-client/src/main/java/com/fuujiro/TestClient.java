package com.fuujiro;

import com.fuujiro.HelloObject;
import com.fuujiro.HelloService;
import com.fuujiro.client.RpcClientProxy;

/**
 * Created by fzy at 4:21 PM on 2020/9/16.
 */
public class TestClient {

    public static void main(String[] args) {
        RpcClientProxy proxy = new RpcClientProxy("127.0.0.1", 9000);
        HelloService helloService = proxy.getProxy(HelloService.class);
        HelloObject object = new HelloObject(12, "This is a message");
        String res = helloService.hello(object);
        System.out.println(res);
    }

}

