package com.nj.rcxc.exception;

import com.nj.rcxc.enums.ResultEnum;

/**
 * Created by Fred on 2018/7/1.
 * 自定义的异常用来处理相关的业务逻辑，例如判断年龄大小等
 */
public class GirlException extends RuntimeException {

    private int code;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public GirlException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }
}
