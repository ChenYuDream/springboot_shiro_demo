package org.jypj.dev.handler;

import org.jypj.dev.exception.SellException;
import org.jypj.dev.exception.TestException;
import org.jypj.dev.result.Result;
import org.jypj.dev.result.ResultUtil;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * 自定义的异常处理类
 *
 * @author ChenYu
 */
@ControllerAdvice
public class SellExceptionHandler {


    //拦截登录异常
    @ExceptionHandler(value = SellException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ModelAndView handlerAuthorizeException(SellException e) {
        return new ModelAndView("exception");
    }

    /**
     * @param e
     * @return
     */
    @ExceptionHandler(value = TestException.class)
    @ResponseBody
    public Result handlerSellException(SellException e) {
        return ResultUtil.fail(e.getMessage());
    }
}
