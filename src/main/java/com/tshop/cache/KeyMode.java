package com.tshop.cache;

/**
 * @Author Han, Tixiang
 * @Create 2016/6/26
 */
public enum KeyMode{
    DEFAULT,    //只有加了@CacheKey的参数,才加入key后缀中
    BASIC,      //只有基本类型参数,才加入key后缀中,如:String,Integer,Long,Short,Boolean
    ALL;        //所有参数都加入key后缀
}