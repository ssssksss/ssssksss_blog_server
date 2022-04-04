package com.example.ssssksss_blog.blog.controller;

import com.example.ssssksss_blog.blog.dto.UserDto;
import com.example.ssssksss_blog.blog.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * PackageName : com.example.ssssksss_blog.blog.controller
 * FileName : UserController
 * Author : 이 수 경
 * Date : 2022-04-03
 * Description :
 */
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

//    회원가입
    @RequestMapping(value="/ssssksss/user/signup", method= RequestMethod.POST)
    public ResponseEntity userSignup(@RequestBody UserDto userDto) {
        return userService.signup(userDto);
    }

}
