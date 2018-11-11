package com.lzc.demo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.BeanUtils;

/**
 * @author lzc 2018/11/11
 * 用于数据返回的包装类
 */
@ApiModel("用户信息返回")
public class UserRes {
    @ApiModelProperty("用户id")
    public Integer id;
    @ApiModelProperty("用户名称")
    public String username;
    @ApiModelProperty("用户年龄")
    public Integer age;
    @ApiModelProperty("用户地址")
    public String address;

    public UserRes(User user) {
        BeanUtils.copyProperties(user, this);
    }
    public UserRes() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
