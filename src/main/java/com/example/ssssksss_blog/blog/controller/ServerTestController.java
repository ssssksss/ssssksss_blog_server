package com.example.ssssksss_blog.blog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * PackageName : com.example.ssssksss_blog.blog.controller
 * FileName : ServerTestController
 * Author : 이 수 경
 * Date : 2022-04-13
 * Description :
 */
@RestController
public class ServerTestController {

    LocalDateTime localDateTime = LocalDateTime.now();

    @RequestMapping("/")
    public String index() throws Exception{
        return localDateTime.toString();
    }
}
