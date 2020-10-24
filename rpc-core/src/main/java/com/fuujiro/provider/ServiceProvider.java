package com.fuujiro.provider;

/**
 * Created by fzy at 16:17 on 2020/10/21.
 */
public interface ServiceProvider {


    <T> void addServiceProvider(T service, String serviceName);

    Object getServiceProvider(String serviceName);

}

