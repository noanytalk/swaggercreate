package com.lzc.demo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author lzc 2018/11/11
 * 前端请求的包装类
 */
@ApiModel("用户信息请求")
public class UserReq {
    @ApiModelProperty("用户id")
    public Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
