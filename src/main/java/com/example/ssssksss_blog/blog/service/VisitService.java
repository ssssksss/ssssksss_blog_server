package com.example.ssssksss_blog.blog.service;

import com.example.ssssksss_blog.blog.dto.UserDto;
import com.example.ssssksss_blog.commonDto.ResponseStatusDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * PackageName : com.example.ssssksss_blog.blog.service
 * FileName : VisitService
 * Author : 이 수 경
 * Date : 2022-04-05
 * Description :
 */
@Service
public class VisitService {

    public ResponseEntity visitTest(String ip) {
        return ResponseEntity.ok().body(new ResponseStatusDto(200,ip));
    }
}
