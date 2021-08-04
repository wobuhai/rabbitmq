package com.disp.transactionaldisp.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * 
 * @TableName disp
 */
@TableName(value ="disp")
public class Disp implements Serializable {
    /**
     * 
     */
    @TableId
    private Integer disid;

    /**
     * 
     */
    private Integer orderid;

    /**
     * 
     */
    private String status;

    /**
     * 
     */
    private Integer userid;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public Integer getDisid() {
        return disid;
    }

    /**
     * 
     */
    public void setDisid(Integer disid) {
        this.disid = disid;
    }

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
    public String getStatus() {
        return status;
    }

    /**
     * 
     */
    public void setStatus(String status) {
        this.status = status;
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