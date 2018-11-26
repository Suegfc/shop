package com.seventh.shop.vo;

/**
 * @author gfc
 * 2018年11月17日 下午 5:04
 * 把数据转为restful风格的接口数据
 */
public class Result<T> {
    /**
     * 返回状态码
     */
    private int code;

    /**
     * 返回状态描述
     */
    private String msg;

    /**
     * 返回数据组装，可传入任意类型数据
     */
    private T data;

    private Object other;

    public Object getOther() {
        return other;
    }

    public void setOther(Object other) {
        this.other = other;
    }

    /**
     * 如果请求处理成功，直接通过该构造方法返回成功状态
     *
     * @param data 需要返回的数据
     */
    private Result(T data) {
        this.code = 0;
        this.msg = "success";
        this.data = data;
    }

    /**
     * 如果请求处理有问题
     *
     * @param cm CodeMsg对象，保存请求失败需要返回的结果
     */
    private Result(CodeMsg cm) {
        if (cm == null) {
            return;
        }
        this.code = cm.getCode();
        this.msg = cm.getMsg();
    }

    /**
     * 请求成功
     *
     * @param data 需要返回的数据
     * @param <T>
     * @return Result<T>类型对象
     */
    public static <T> Result<T> success(T data) {
        return new Result(data);
    }

    /**
     * 请求异常
     *
     * @param cm  CodeMsg对象，保存异常信息
     * @param <T>
     * @return Result<T>类型对象
     */
    public static <T> Result<T> error(CodeMsg cm) {
        return new Result(cm);
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Result() {
    }
}
