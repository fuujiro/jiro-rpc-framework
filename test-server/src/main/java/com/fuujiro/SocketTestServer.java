package com.fuujiro;

import com.fuujiro.register.DefaultServiceRegistry;
import com.fuujiro.register.ServiceRegistry;
import com.fuujiro.socket.server.SocketServer;

/**
 * Created by fzy at 17:47 on 2020/10/19.
 */
public class SocketTestServer {

    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();
        ServiceRegistry serviceRegistry = new DefaultServiceRegistry();
        serviceRegistry.register(helloService);
        SocketServer socketServer = new SocketServer(serviceRegistry);
        socketServer.start(9000);
    }

}
