package com.fuujiro.server;

import com.fuujiro.enumeration.ResponseCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fuujiro.entity.RpcRequest;
import com.fuujiro.entity.RpcResponse;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;

/**
 * Created by fzy at 3:49 PM on 2020/9/16.
 */
public class RequestHandler implements Runnable {

    private static final Logger logger = LoggerFactory.getLogger(RequestHandler.class);

    private Socket socket;
    private Object service;

    public RequestHandler(Socket socket, Object service) {
        this.socket = socket;
        this.service = service;
    }

    @Override
    public void run() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream())) {
            RpcRequest rpcRequest = (RpcRequest) objectInputStream.readObject();
            Object returnObject = invokeMethod(rpcRequest);
            objectOutputStream.writeObject(RpcResponse.success(returnObject));
            objectOutputStream.flush();
        } catch (IOException | ClassNotFoundException | IllegalAccessException | InvocationTargetException e) {
            logger.error("调用或发送时有错误发生：", e);
        }
    }

    private Object invokeMethod(RpcRequest rpcRequest) throws IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        Class<?> clazz = Class.forName(rpcRequest.getInterfaceName());
        if (!clazz.isAssignableFrom(service.getClass())) {
            return RpcResponse.fail(ResponseCode.CLASS_NOT_FOUND);
        }
        Method method;
        try {
            method = service.getClass().getMethod(rpcRequest.getInterfaceName(), rpcRequest.getParamTypes());
        } catch (NoSuchMethodException e) {
            return RpcResponse.fail(ResponseCode.METHOD_NOT_FOUND);
        }
        return method.invoke(service, rpcRequest.getParameters());
    }
}
