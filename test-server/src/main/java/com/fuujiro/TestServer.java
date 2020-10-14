package com.fuujiro;

import com.fuujiro.HelloService;
import com.fuujiro.registry.DefaultServiceRegistry;
import com.fuujiro.registry.ServiceRegistry;
import com.fuujiro.server.RpcServer;

/**
 * Created by fzy at 4:19 PM on 2020/9/16.
 */
public class TestServer {

    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();
        ServiceRegistry serviceRegistry = new DefaultServiceRegistry();
        serviceRegistry.register(helloService);
        RpcServer rpcServer = new RpcServer(serviceRegistry);
        rpcServer.start(9000);

    }

}