package enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by fzy at 17:08 on 2020/10/16.
 */

// response里的状态码

@AllArgsConstructor
@Getter
public enum ResponseCode {

    SUCCESS(200,"调用方法成功"),
    FAIL(500,"调用方法失败"),
    METHOD_NOT_FOUND(500,"未找到指定方法"),
    CLASS_NOT_FOUND(500,"未找到指定类");

    private final int code;
    private final String message;

}
