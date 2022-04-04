package com.example.ssssksss_blog.blog.controller;

import com.example.ssssksss_blog.blog.dto.PostDto;
import com.example.ssssksss_blog.blog.service.VisitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * PackageName : com.example.ssssksss_blog.blog.controller
 * FileName : VisitController
 * Author : 이 수 경
 * Date : 2022-04-04
 * Description :
 */
@RestController
@RequiredArgsConstructor
public class VisitController {

    private final VisitService visitService;

    @RequestMapping(value="/ssssksss/visit", method= RequestMethod.GET)
    public ResponseEntity addPost(HttpServletRequest request) {
        System.out.println("visit controller");

        String ip = request.getHeader("X-Forwarded-For");

        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        System.out.println(ip);
        return visitService.visitTest(ip);
    }
//
}
