package cn.mydrn.utils;

/**
 * 自定义HTTP 状态码
 *
 * @author mydrn 2018年10月14日
 */
public enum HttpStatus {
    /**
     * 需要登录
     */
    NEED_LOGIN(310, "need login"),

    /**
     * 参数错误
     */
    INVALID_PARAMETER(312, "invalid parameter"),

    /**
     * 含有敏感字符
     */
    SENSITIVE_PARAMETER(313, "sensitive parameter"),

    /**
     * 需要权限
     */
    NEED_PERMISSION(311, "need permission");

    private final int value;

    private final String reasonPhrase;

    HttpStatus(int value, String reasonPhrase) {
        this.value = value;
        this.reasonPhrase = reasonPhrase;
    }

    public int getValue() {
        return value;
    }

    public String getReasonPhrase() {
        return reasonPhrase;
    }
}
