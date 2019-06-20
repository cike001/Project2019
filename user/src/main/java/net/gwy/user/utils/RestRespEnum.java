package net.gwy.user.utils;

/**
 * @author guoweiyang
 * @date 2019-05-01
 */
public enum RestRespEnum {

    success(200,"success");

    private Integer code;
    private String msg;

    RestRespEnum(Integer code, String msg) {
            this.code = code;
            this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
