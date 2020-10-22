package com.fuujiro.register;

import java.net.InetSocketAddress;

/**
 * Created by fzy at 17:26 on 2020/10/19.
 */
public interface ServiceRegistry {

    /**
     * 将一个服务注册进注册表
     *
     * @param serviceName 服务名称
     * @param inetSocketAddress 提供服务的地址
     */
    void register(String serviceName, InetSocketAddress inetSocketAddress);


}
