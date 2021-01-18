package com.gaurav.user.controller;

import com.gaurav.user.entity.User;
import com.gaurav.user.service.UserService;
import com.gaurav.user.vo.ResponseTemplateVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user){
        log.info("UserController::saveUser");
        return userService.saveUser(user);
    }

    @GetMapping("/{userId}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("userId") Long userId){
        log.info("UserController::getUserWithDepartment");
        return userService.getUserWithDepartment(userId);
    }
}
