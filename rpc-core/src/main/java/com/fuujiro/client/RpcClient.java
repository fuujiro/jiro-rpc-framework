package com.fuujiro.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fuujiro.entity.RpcRequest;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Created by fzy at 4:07 PM on 2020/9/16.
 */
public class RpcClient {

    private static final Logger logger = LoggerFactory.getLogger(RpcClient.class);

    public Object sendRequest(RpcRequest rpcRequest, String host, int port) {
        try (Socket socket = new Socket(host, port)) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            objectOutputStream.writeObject(rpcRequest);
            objectOutputStream.flush();
            return objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            logger.error("调用时有错误发生：", e);
            return null;
        }
    }

}

