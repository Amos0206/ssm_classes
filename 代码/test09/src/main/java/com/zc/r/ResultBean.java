package com.zc.r;

import lombok.*;

import java.io.Serializable;

/**
 * @author zhch2
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ResultBean implements Serializable {
    /**
     * 返回给前端的code码 1001表示失败 1000表示成功
     */
    private int code;
    /**
     * 返回的具体信息
     */
    private String message;
    /**
     * 返回的数据
     */
    private Object data;


    /**
     * 返回成功具体数据
     * @return
     */
    public static ResultBean success(Object data){
        ResultBean r = new ResultBean();
        r.setCode(1000);
        r.setMessage("操作成功");
        r.setData(data);
        return r;
    }

    /**
     * 返回成功的具体信息和数据
     * @param msg
     * @param data
     * @return
     */
    public static ResultBean success(String msg,Object data){
        ResultBean r = new ResultBean();
        r.setCode(1000);
        r.setMessage(msg);
        r.setData(data);
        return r;
    }


    /**
     * 返回错误
     * @return
     */
    public static ResultBean error(){
        ResultBean r = new ResultBean();
        r.setCode(1001);
        r.setMessage("操作失败");
        r.setData(null);
        return r;
    }

    /**
     * 返货错误的具体信息
     * @param msg
     * @return
     */
    public static ResultBean error(String msg){
        ResultBean r = new ResultBean();
        r.setCode(1001);
        r.setMessage(msg);
        r.setData(null);
        return r;
    }
}