package com.iyy.myframework.exception;

/**
 * Created by wuyue on 2016/6/21.
 *
 * 系统中所有的异常转化为exception
 */
public class BaseException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public BaseException(){
        super();
    }

    public BaseException(String detailMessage,Throwable throwable){
        super(detailMessage,throwable);
    }

    public BaseException(String detailMessage){
        super(detailMessage);
    }

    public BaseException(Throwable throwable){
        super(throwable);
    }
}
