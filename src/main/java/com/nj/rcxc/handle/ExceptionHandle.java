package com.nj.rcxc.handle;

import com.nj.rcxc.domain.Result;
import com.nj.rcxc.exception.GirlException;
import com.nj.rcxc.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Fred on 2018/7/1.
 * 用来处理捕获的异常信息，这里是对自定义的异常信息进行捕获处理
 */
@ControllerAdvice
public class ExceptionHandle {
    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if(e instanceof GirlException){
            GirlException girlException = (GirlException) e;
            return ResultUtil.error(girlException.getCode(),girlException.getMessage());
        }else{
            logger.error("[系统异常]{}",e);
            return ResultUtil.error(-1,"未知错误");
        }
    }
}
