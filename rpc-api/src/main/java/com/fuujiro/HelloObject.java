package com.fuujiro;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by fzy at 4:15 PM on 2020/9/16.
 */
@Data
@AllArgsConstructor
public class HelloObject implements Serializable {

    private Integer id;
    private String message;

}
