package org.jypj.dev.exception;

import lombok.Getter;
import org.jypj.dev.result.ResultEnum;

/**
 * 自定义的异常
 * @author ChenYu
 */
@Getter
public class SellException extends RuntimeException {

    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public SellException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
