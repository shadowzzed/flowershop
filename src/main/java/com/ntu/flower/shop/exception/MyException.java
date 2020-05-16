package com.ntu.flower.shop.exception;

import com.ntu.flower.shop.exception.ex.MyExceptionEnum;
import lombok.Data;

/**
 * @author Zed
 * @date 2020/5/16 上午12:57
 * @contact shadowl91@163.com
 */
@Data
public class MyException extends RuntimeException {
    private String code;

    private String msg;

    public MyException(MyExceptionEnum myExceptionEnum) {
        super(myExceptionEnum.getMsg());
        this.code = myExceptionEnum.getCode();
    }
}
