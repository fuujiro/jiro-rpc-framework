package com.fuujiro.transport;

import com.fuujiro.entity.RpcRequest;
import com.fuujiro.entity.RpcResponse;
import com.fuujiro.transport.netty.client.NettyClient;
import com.fuujiro.transport.socket.client.SocketClient;
import com.fuujiro.util.RpcMessageChecker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Created by fzy at 17:24 on 2020/10/19.
 */
public class RpcClientProxy implements InvocationHandler {

    private static final Logger logger = LoggerFactory.getLogger(RpcClientProxy.class);

    private final RpcClient client;

    public RpcClientProxy(RpcClient client) {
        this.client = client;
    }

    @SuppressWarnings("unchecked")
    public <T> T getProxy(Class<T> clazz) {
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class<?>[]{clazz}, this);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        logger.info("调用方法: {}#{}", method.getDeclaringClass().getName(), method.getName());
        RpcRequest rpcRequest = new RpcRequest(UUID.randomUUID().toString(), method.getDeclaringClass().getName(),
                method.getName(), args, method.getParameterTypes(), false);
        RpcResponse rpcResponse = null;
        if (client instanceof NettyClient) {
            CompletableFuture<RpcResponse> completableFuture = (CompletableFuture<RpcResponse>) client.sendRequest(rpcRequest);
            try {
                rpcResponse = completableFuture.get();
            } catch (InterruptedException | ExecutionException e) {
                logger.error("方法调用请求发送失败", e);
                return null;
            }
        }
        if (client instanceof SocketClient) {
            rpcResponse = (RpcResponse) client.sendRequest(rpcRequest);
        }
        RpcMessageChecker.check(rpcRequest, rpcResponse);
        return rpcResponse.getData();
    }
}
