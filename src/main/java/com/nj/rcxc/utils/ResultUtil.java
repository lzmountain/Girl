package com.nj.rcxc.utils;

import com.nj.rcxc.domain.Result;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Fred on 2018/6/30.
 */
public class ResultUtil {

    public static Result success(Object object){
        Result result = new Result();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(object);
        return result;

    }
    public static Result success(){
        return success(null);
    }
    public static Result error(int code,String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
