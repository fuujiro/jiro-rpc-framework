package com.fuujiro.transport.socket.server;

import com.fuujiro.enumeration.RpcError;
import com.fuujiro.exception.RpcException;
import com.fuujiro.handler.RequestHandler;
import com.fuujiro.hook.ShutdownHook;
import com.fuujiro.provider.ServiceProvider;
import com.fuujiro.provider.ServiceProviderImpl;
import com.fuujiro.register.NacosServiceRegistry;
import com.fuujiro.serializer.CommonSerializer;
import com.fuujiro.transport.AbstractRpcServer;
import com.fuujiro.transport.RpcServer;
import com.fuujiro.register.ServiceRegistry;
import com.fuujiro.factory.ThreadPoolFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

/**
 * Created by fzy at 17:45 on 2020/10/19.
 */
public class SocketServer extends AbstractRpcServer {

    private final ExecutorService threadPool;
    private final CommonSerializer serializer;
    private final RequestHandler requestHandler = new RequestHandler();

    public SocketServer(String host, int port) {
        this(host, port, DEFAULT_SERIALIZER);
    }

    public SocketServer(String host, int port, Integer serializer) {
        this.host = host;
        this.port = port;
        threadPool = ThreadPoolFactory.createDefaultThreadPool("socket-rpc-server");
        this.serviceRegistry = new NacosServiceRegistry();
        this.serviceProvider = new ServiceProviderImpl();
        this.serializer = CommonSerializer.getByCode(serializer);
        scanServices();
    }

    @Override
    public void start() {
        try (ServerSocket serverSocket = new ServerSocket()) {
            serverSocket.bind(new InetSocketAddress(host, port));
            logger.info("服务器启动……");
            ShutdownHook.getShutdownHook().addClearAllHook();
            Socket socket;
            while ((socket = serverSocket.accept()) != null) {
                logger.info("消费者连接: {}:{}", socket.getInetAddress(), socket.getPort());
                threadPool.execute(new SocketRequestHandlerThread(socket, requestHandler, serializer));
            }
            threadPool.shutdown();
        } catch (IOException e) {
            logger.error("服务器启动时有错误发生:", e);
        }
    }

}
