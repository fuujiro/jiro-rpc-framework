package com.fuujiro;

import com.fuujiro.netty.server.NettyServer;
import com.fuujiro.register.DefaultServiceRegistry;
import com.fuujiro.register.ServiceRegistry;

/**
 * Created by fzy at 17:46 on 2020/10/19.
 */
public class NettyTestServer {

    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();
        ServiceRegistry registry = new DefaultServiceRegistry();
        registry.register(helloService);
        NettyServer server = new NettyServer();
        server.start(9999);
    }

}
