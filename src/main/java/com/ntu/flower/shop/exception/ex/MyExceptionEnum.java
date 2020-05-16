package com.ntu.flower.shop.exception.ex;

import lombok.Getter;

/**
 * @author Zed
 * @date 2020/5/16 上午12:07
 * @contact shadowl91@163.com
 */
@Getter
public enum MyExceptionEnum {

//    SUCCESS("200","SUCCESS"),
    JSON_IS_NULL("401","JSON IS NULL"),
    LOST_PARAM("402","PARAMETER LOST"),
    ACCOUNT_EXISTED("403", "ACCOUNT EXISTED"),
    ACCOUNT_NOT_EXISTED("404","ACCOUNT NOT EXISTED"),
    PASSWORD_WRONG("405", "PASSWORD WRONG"),
    COLLECT_NOT_EXISTED("406","COLLECT NO EXIST"),
    FLOWER_NOT_EXISTED("407","FLOWER DOES NOT EXIST"),
    CANNOT_REPEAT_ADD("408","CAN NOT REPEAT ADD COLLECT"),
    SYS_ERROR("500","SERVER ERROR"),
    METHOD_WRONG("501","METHOD NOT SUPPORTED")
    ;

    private String code;

    private String msg;

    MyExceptionEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
