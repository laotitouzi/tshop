package com.tshop.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * Created by hantixiang on 2016/5/15.
 */
public class JsonUtils {

    public static JSONObject parse(String json){
        JSONObject obj =  JSON.parseObject(json);
        return obj;
    }

    public static<T>  T parse(String json,  Class<T> clazz){
        T t =  JSON.parseObject(json,clazz);
        return t;
    }

    public static String toJSONString(Object obj){
        return JSON.toJSONString(obj);
    }
}
