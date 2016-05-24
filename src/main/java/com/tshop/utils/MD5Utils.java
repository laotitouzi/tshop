package com.tshop.utils;

import org.apache.commons.lang.StringUtils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Author Han, Tixiang
 * @Create 2016/5/22
 */
public class MD5Utils {
    public static String md5(String word) {
        if (StringUtils.isBlank(word)) {
            return "";
        }
        try {
            //创建一个提供信息摘要算法的对象，初始化为md5算法对象
            MessageDigest md = MessageDigest.getInstance("MD5");
            //计算后获得字节数组
            byte[] buff = md.digest(word.getBytes("UTF-8"));
            //把数组每一字节换成16进制连成md5字符串
            return bytesToHex(buff);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }


    public static String bytesToHex(byte[] bytes) {
        StringBuffer md5str = new StringBuffer();
        //把数组每一字节换成16进制连成md5字符串
        int digital;
        for (int i = 0; i < bytes.length; i++) {
            digital = bytes[i];
            if (digital < 0) {
                digital += 256;
            }
            if (digital < 16) {
                md5str.append("0");
            }
            md5str.append(Integer.toHexString(digital));
        }
        return md5str.toString();
    }

    public static void main(String[] args) {
        System.out.println(md5("e10adc3949ba59abbe56e057f20f883e"));
    }
}
