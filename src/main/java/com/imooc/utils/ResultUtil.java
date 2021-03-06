package com.imooc.utils;

import com.imooc.domain.Result;

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

    public static Result failure(Integer code,String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(null);

        return result;
    }
}
