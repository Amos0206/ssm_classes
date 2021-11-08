package com.zc.R;

import lombok.*;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/11/2 10:39
 * @desc 自定义返回类型
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ResultBean {
    private int code; // 返回给前端的code码 1001表示失败 1000表示成功
    private String message; //返回的具体信息
    private Object data; //返回的数据


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
