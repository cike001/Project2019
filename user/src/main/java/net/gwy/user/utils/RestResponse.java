package net.gwy.user.utils;

import lombok.Data;

/**
 * @author guoweiyang
 * @date 2019-05-01
 */
@Data
public class RestResponse<T>  {

    private Integer code;
    private String msg;
    private T data;


    public RestResponse(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public RestResponse(T data) {
        this.code = RestRespEnum.success.getCode();
        this.msg = RestRespEnum.success.getMsg();
        System.out.println(code+"-"+msg);
        this.data = data;
    }
}
