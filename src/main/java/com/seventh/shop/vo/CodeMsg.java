package com.seventh.shop.vo;

/**
 * @author gfc
 * 2018年11月17日 下午 5:11
 */
public class CodeMsg {

    /**
     * 状态码
     */
    private int code;

    /**
     * 异常信息描述
     */
    private String msg;

    private CodeMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 可定义各种异常静态变量
     */
    public static CodeMsg ERROR = new CodeMsg(1, "failed");
    public static CodeMsg SUCCESS = new CodeMsg(0, "success");

    /**
     * ......有需要再加
     */

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public static  CodeMsg newError(int Code,String Msg){
        ERROR.code=Code;
        ERROR.msg=Msg;
        return ERROR;
    }

}
