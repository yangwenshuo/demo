package com.stt.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

//对于到了controller的异常的全局处理
@ControllerAdvice
public class ExceptionHandlerTest {

    @ExceptionHandler(Error.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)   //这个会设置响应码,让前端知道500了
    @ResponseBody
    public Map<Object, Object> preErr() {
        Map m = new HashMap<Object, Object>();

        m.put("你好啊", "error");

        return m;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)   //这个会设置响应码,让前端知道500了
    @ResponseBody
    public Map<Object, Object> preExe() {
        Map m = new HashMap<Object, Object>();

        m.put("你好啊", "Exception");

        return m;
    }
}