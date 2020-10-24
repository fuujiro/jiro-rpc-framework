package com.fuujiro;

import com.fuujiro.annotation.ServiceScan;
import com.fuujiro.register.ServiceRegistry;
import com.fuujiro.serializer.CommonSerializer;
import com.fuujiro.serializer.HessianSerializer;
import com.fuujiro.serializer.KryoSerializer;
import com.fuujiro.transport.RpcServer;
import com.fuujiro.transport.socket.server.SocketServer;

/**
 * Created by fzy at 17:47 on 2020/10/19.
 */
@ServiceScan
public class SocketTestServer {

    public static void main(String[] args) {
        RpcServer server = new SocketServer("127.0.0.1", 9998, CommonSerializer.HESSIAN_SERIALIZER);
        server.start();
    }

}