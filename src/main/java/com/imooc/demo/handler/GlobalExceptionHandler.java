package com.imooc.demo.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    //不是返回HTML页面，而是返回错误信息所以用ResponseBody
    @ResponseBody
    //异常处理方法统一处理所有异常，可以对每个service自定义异常类然后在这里写异常处理方法，此时接受的就不是Exception.class而是继承于Exception的错误类
    private Map<String,Object> exceptionHandler(HttpServletRequest req, Exception e){
        Map<String,Object> modelMap = new HashMap<String,Object>();
        modelMap.put("success",false);
        modelMap.put("errMsg",e.getMessage());
        return modelMap;
    }
}
