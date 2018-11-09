package com.lzc.demo.controller;

import com.lzc.demo.dto.User;
import com.lzc.demo.dto.UserList;
import com.lzc.demo.dto.UserReq;
import com.lzc.demo.dto.UserRes;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Api(tags = "用户接口")//API文档控制的标记列表。标记可用于根据资源或任何其他限定符对操作进行逻辑分组
@RestController
@RequestMapping("/test/user")
public class TestController {

    @ApiOperation(value = "查询用户信息")
    @PostMapping("me")
    public UserRes getUser(@RequestBody UserReq req) {
        Optional<User> optional = User.getUsers().values().stream().distinct().filter(user -> user.getId() != null && user.getId().equals(req.getId())).findAny();
        if (!optional.isPresent()) {
            return new UserRes();
        }
        return new UserRes(optional.orElseGet(() -> new User()));
    }

    @ApiOperation(value = "查询所有用户信息列表")
    @GetMapping("")
    public UserList<UserRes> listUser() {
        //int a = 1 / 0;
        //List<User> users = new ArrayList<>();
        List<User> users = User.getUsers().values().stream().collect(Collectors.toList());
        UserList<UserRes> list = new UserList<>(users, UserRes::new);
        return list;
    }
}
