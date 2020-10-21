package com.fuujiro.transport.socket.server;

import com.fuujiro.handler.RequestHandler;
import com.fuujiro.entity.RpcRequest;
import com.fuujiro.entity.RpcResponse;
import com.fuujiro.register.ServiceRegistry;
import com.fuujiro.serializer.CommonSerializer;
import com.fuujiro.transport.socket.util.ObjectReader;
import com.fuujiro.transport.socket.util.ObjectWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.Socket;

/**
 * Created by fzy at 17:45 on 2020/10/19.
 */
public class RequestHandlerThread implements Runnable {

    private static final Logger logger = LoggerFactory.getLogger(RequestHandlerThread.class);

    private Socket socket;
    private RequestHandler requestHandler;
    private ServiceRegistry serviceRegistry;
    private CommonSerializer serializer;

    public RequestHandlerThread(Socket socket, RequestHandler requestHandler, ServiceRegistry serviceRegistry, CommonSerializer serializer) {
        this.socket = socket;
        this.requestHandler = requestHandler;
        this.serviceRegistry = serviceRegistry;
        this.serializer = serializer;
    }

    @Override
    public void run() {
        try (InputStream inputStream = socket.getInputStream();
             OutputStream outputStream = socket.getOutputStream()) {
            RpcRequest rpcRequest = (RpcRequest) ObjectReader.readObject(inputStream);
            String interfaceName = rpcRequest.getInterfaceName();
            Object result = requestHandler.handle(rpcRequest);
            RpcResponse<Object> response = RpcResponse.success(result, rpcRequest.getRequestId());
            ObjectWriter.writeObject(outputStream, response, serializer);
        } catch (IOException e) {
            logger.error("调用或发送时有错误发生：", e);
        }
    }

}
