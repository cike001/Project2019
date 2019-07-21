package net.gwy.mybatisplusgenerator.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import net.gwy.mybatisplusgenerator.model.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author guoweiyang
 * @since 2019-07-02
 */
@Api(value = "用户控制器",tags = {"用户操作接口"})
@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ApiOperation(value = "保存用户",tags = {"保存用户信息"},notes = "1")
    public Boolean saveUser(@RequestBody @ApiParam(name = "用户对象",value = "json格式",required = true) User user){
        return true;
    }
}

