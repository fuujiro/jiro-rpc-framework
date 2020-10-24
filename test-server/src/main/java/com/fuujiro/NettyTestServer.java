package com.fuujiro;

import com.fuujiro.annotation.ServiceScan;
import com.fuujiro.serializer.CommonSerializer;
import com.fuujiro.serializer.ProtobufSerializer;
import com.fuujiro.transport.RpcServer;
import com.fuujiro.transport.netty.server.NettyServer;
import com.fuujiro.register.ServiceRegistry;

/**
 * Created by fzy at 17:46 on 2020/10/19.
 */
@ServiceScan
public class NettyTestServer {

    public static void main(String[] args) {
        RpcServer server = new NettyServer("127.0.0.1", 9999, CommonSerializer.PROTOBUF_SERIALIZER);
        server.start();
    }

}
