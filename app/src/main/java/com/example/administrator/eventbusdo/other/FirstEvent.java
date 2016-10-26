package com.example.administrator.eventbusdo.other;

/**
 * Created by Administrator on 2016/7/19.
 */
public class FirstEvent {
    private final String msg;

    public FirstEvent(String msg) {
        this.msg=msg;
    }

    public String getMsg() {
        return msg;
    }
}
