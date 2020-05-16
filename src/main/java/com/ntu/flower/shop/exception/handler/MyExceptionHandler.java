package com.ntu.flower.shop.exception.handler;

import com.ntu.flower.shop.domain.Resp;
import com.ntu.flower.shop.exception.MyException;
import com.ntu.flower.shop.exception.ex.MyExceptionEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Zed
 * @date 2020/5/16 上午12:15
 * @contact shadowl91@163.com
 */
@ControllerAdvice
@Slf4j
public class MyExceptionHandler {

    @SuppressWarnings("rawtypes")
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Resp jsonErrorHandler(Exception e) {
        Resp res = new Resp();

        if (e instanceof MyException) {
            res.setCode(((MyException) e).getCode());
            res.setMsg(e.getMessage());
        } else {
            log.error("[my exception handler] ,e={}", e.getMessage());
            if (e instanceof HttpRequestMethodNotSupportedException) {
                res.setCode(MyExceptionEnum.METHOD_WRONG.getCode());
                res.setMsg(MyExceptionEnum.METHOD_WRONG.getMsg());
            }
            res.setCode(MyExceptionEnum.SYS_ERROR.getCode());
            res.setMsg(MyExceptionEnum.SYS_ERROR.getMsg());
        }
        log.info("[my exception handler] res = {}", res);
        return res;
    }
}
