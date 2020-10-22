package com.fuujiro;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by fzy at 21:12 on 2020/10/22.
 */
public class HelloServiceImpl2 implements HelloService {

    private static final Logger logger = LoggerFactory.getLogger(HelloServiceImpl2.class);

    @Override
    public String hello(HelloObject object) {
        logger.info("接收到消息：{}", object.getMessage());
        return "本次处理来自Socket服务";
    }
}
