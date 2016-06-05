package com.tshop.exception;

/**
 * @Author Han, Tixiang
 * @Create 2016/5/30
 */
public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = 3152616724785436891L;

    public BusinessException(String message) {
        super(createFriendlyErrMsg(message));
    }

    public BusinessException(Throwable throwable) {
        super(throwable);
    }

    public BusinessException(Throwable throwable, String frdMessage) {
        super(throwable);
    }

    private static String createFriendlyErrMsg(String msgBody) {
        String prefixStr = "抱歉，";
        String suffixStr = " 请稍后再试或与管理员联系！";

        StringBuffer friendlyErrMsg = new StringBuffer("");

        friendlyErrMsg.append(prefixStr);
        friendlyErrMsg.append(msgBody);
        friendlyErrMsg.append(suffixStr);
        return friendlyErrMsg.toString();
    }
}
