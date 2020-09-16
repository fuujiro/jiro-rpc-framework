package com.fuujiro;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fuujiro.HelloObject;
import com.fuujiro.HelloService;

/**
 * Created by fzy at 4:17 PM on 2020/9/16.
 */
public class HelloServiceImpl implements HelloService {

    private static final Logger logger = LoggerFactory.getLogger(HelloServiceImpl.class);

    @Override
    public String hello(HelloObject object) {
        logger.info("接收到：{}", object.getMessage());
        return "这是掉用的返回值，id=" + object.getId();
    }

}

