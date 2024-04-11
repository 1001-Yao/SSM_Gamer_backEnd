package com.ygq.furn.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * 后端程序返回给前端的json数据的Message对象->本质即数据规则
 */
public class Msg {
    //状态码200-成功；400-失败
    private int code;
    //信息说明
    private String msg;

    //返回给客户端/浏览器-map集合
    private Map<String,Object> extend=new HashMap<>();

    public Msg() {
    }

    //编写几个常用的方法
    //发送或者运行成功与失败的方法
    public static Msg success() {
        Msg res = new Msg();
        res.setCode(200);
        res.setMsg("success");
        return res;
    }
    public static Msg fail() {
        Msg res = new Msg();
        res.setCode(400);
        res.setMsg("fail");
        return res;
    }
//给返回的msg设置数据
    public Msg add(String key, Object value) {
        this.getExtend().put(key, value);
        return this;
    }

    public Msg(int code, String msg, Map<String, Object> extend) {
        this.code = code;
        this.msg = msg;
        this.extend = extend;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String meg) {
        this.msg = meg;
    }

    public Map<String, Object> getExtend() {
        return extend;
    }

    public void setExtend(Map<String, Object> extend) {
        this.extend = extend;
    }


}
