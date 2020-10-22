package com.fuujiro;

import com.fuujiro.register.ServiceRegistry;
import com.fuujiro.serializer.CommonSerializer;
import com.fuujiro.serializer.HessianSerializer;
import com.fuujiro.serializer.KryoSerializer;
import com.fuujiro.transport.socket.server.SocketServer;

/**
 * Created by fzy at 17:47 on 2020/10/19.
 */
public class SocketTestServer {

    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl2();
        SocketServer socketServer = new SocketServer("127.0.0.1", 9998, CommonSerializer.HESSIAN_SERIALIZER);
        socketServer.publishService(helloService, HelloService.class);
    }

}
