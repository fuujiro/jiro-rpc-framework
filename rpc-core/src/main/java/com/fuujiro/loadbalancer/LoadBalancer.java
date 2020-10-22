package com.fuujiro.loadbalancer;

import com.alibaba.nacos.api.naming.pojo.Instance;

import java.util.List;

/**
 * Created by fzy at 20:38 on 2020/10/22.
 */
public interface LoadBalancer {

    Instance select(List<Instance> instances);

}
