package com.dvsnier.utils.event;

public class BaseEvent {

    protected int what;
    protected int arg1;
    protected int arg2;
    protected String msg;
    protected Object obj;

    public BaseEvent() {
    }

    public BaseEvent(int what) {
        this.what = what;
    }

    public int getWhat() {
        return what;
    }

    public void setWhat(int what) {
        this.what = what;
    }

    public int getArg1() {
        return arg1;
    }

    public void setArg1(int arg1) {
        this.arg1 = arg1;
    }

    public int getArg2() {
        return arg2;
    }

    public void setArg2(int arg2) {
        this.arg2 = arg2;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    @Override
    public String toString() {
        return "BaseEvent{" +
                "what=" + what +
                ", arg1=" + arg1 +
                ", arg2=" + arg2 +
                ", msg='" + msg + '\'' +
                ", obj=" + obj +
                '}';
    }
}
