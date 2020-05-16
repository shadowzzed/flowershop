package com.ntu.flower.shop.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Zed
 * @date 2020/5/16 上午12:52
 * @contact shadowl91@163.com
 */
@Data
public class Resp<T> implements Serializable {
    private String code;

    private String msg;

    private T data;

    public Resp() {
    }

    public Resp(Builder builder) {
        this.code = builder.bCode;
        this.msg = builder.bMsg;
        this.data = (T) builder.bData;
    }

    public static class Builder<T> {
        private String bCode;

        private String bMsg;

        private T bData;

        public Builder() {

        }

        public Builder<T> code(String code) {
            this.bCode = code;
            return this;
        }

        public Builder<T> msg(String msg) {
            this.bMsg = msg;
            return this;
        }

        public Builder<T> data(T data) {
            this.bData = data;
            return this;
        }

        public Resp<T> build() {
            return new Resp<>(this);
        }
    }
}
