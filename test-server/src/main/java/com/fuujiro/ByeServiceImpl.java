package com.fuujiro;

import com.fuujiro.annotation.Service;

/**
 * Created by fzy at 11:22 on 2020/10/24.
 */
@Service
public class ByeServiceImpl implements ByeService {

    @Override
    public String bye(String name) {
        return "bye, " + name;
    }
}