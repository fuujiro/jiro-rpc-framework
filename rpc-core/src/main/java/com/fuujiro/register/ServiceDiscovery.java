package com.fuujiro.register;

import java.net.InetSocketAddress;

/**
 * Created by fzy at 20:41 on 2020/10/22.
 */
public interface ServiceDiscovery {

    /**
     * 根据服务名称查找服务实体
     *
     * @param serviceName 服务名称
     * @return 服务实体
     */
    InetSocketAddress lookupService(String serviceName);

}
