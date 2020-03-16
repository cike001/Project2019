package net.gwy.test.test.util;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * @author gwy
 * @time 2020-02-11 15:10
 * @desc TODO
 **/
@Data
public class AAA implements Serializable {


    /**
     * 第三方订单号
     */
    private String partnerOrderId;
    /**
     * 用户ID
     */
    private String userId;
    /**
     * 开户类型 1-注册开户 2-换卡
     */
    private String openAccountType;
    /**
     * 银行审核状态 2-通过 3-回退 4-拒绝
     */
    private String auditStatus;
    /**
     * 绑定状态 1-成功 2-失败
     */
    private String bindStatus;
    /**
     * 银行卡号
     */
    @JSONField(serialize = false)
    private String bankCardNo;
    /**
     * 手机号
     */
    @JSONField(serialize = false)
    private String mobile;
    /**
     * 用户名称（注册开户才会返回）
     */
    @JSONField(serialize = false)
    private String realName;
    /**
     * 身份证号（注册开户才会返回）
     */
    @JSONField(serialize = false)
    private String idCardNo;
    /**
     * 失败原因（绑定失败才会返回，否则返回空字符串）
     */
    private String reason;
    /**
     * 银行编码 ABOC:中国农业银行 BKCH:中国银行 CIBK:中信银行 EVER:中国光大银行 FJIB:兴业银行 GDBK:广发银行 HXBK:华夏银行 ICBK:中国工商银行 MSBC:中国民生银行 PSBC:中国邮政储蓄银行 SZDB:平安银行 SPDB:浦发银行 BJCN:北京银行 CMBC:招商银行 COMM:交通银行 PCBC:中国建设银行 BOSH:上海银行 CBXM:厦门银行
     */
    private String bankCode;

}
