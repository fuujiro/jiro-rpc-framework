package com.fuujiro;

import com.fuujiro.HelloService;
import com.fuujiro.server.RpcServer;

/**
 * Created by fzy at 4:19 PM on 2020/9/16.
 */
public class TestServer {

    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();
        RpcServer rpcServer = new RpcServer();
        rpcServer.register(helloService, 9000);
    }

}