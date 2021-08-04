package com.disp.transactionaldisp.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * 
 * @TableName order
 */
@TableName(value ="order")
public class Ordery implements Serializable {
    /**
     * 
     */
    @TableId
    private Integer orderid;

    /**
     * 
     */
    private String orderContent;

    /**
     * 
     */
    private Integer userid;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public Integer getOrderid() {
        return orderid;
    }

    /**
     * 
     */
    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    /**
     * 
     */
    public String getOrderContent() {
        return orderContent;
    }

    /**
     * 
     */
    public void setOrderContent(String orderContent) {
        this.orderContent = orderContent;
    }

    /**
     * 
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * 
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }
}