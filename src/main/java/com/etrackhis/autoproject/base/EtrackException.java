package com.etrackhis.autoproject.base;

import lombok.Getter;



@Getter
public class EtrackException extends RuntimeException{

    private int code;
    private String msg;

    public EtrackException(){
        super();
        this.msg = "空值错误" ;
    }

    public EtrackException(String m){
        super(m);
        this.msg = m;
    }
    public EtrackException(String m, int c){
        super(m);
        this.msg = m;
        this.code = c;
    }
    public EtrackException(String m, Throwable e){
        super(m);
        this.msg = m;
    }
    public EtrackException(String m, int c, Throwable e){
        super(m);
        this.msg = m;
        this.code = c;
    }

    public String getMessage(){
        return msg;
    }

}
