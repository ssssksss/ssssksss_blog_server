package com.example.ssssksss_blog.blog.service;

import com.example.ssssksss_blog.blog.dto.UserDto;
import com.example.ssssksss_blog.blog.repository.PostRepository;
import com.example.ssssksss_blog.blog.repository.UserRepository;
import com.example.ssssksss_blog.commonDto.ResponseStatusDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * PackageName : com.example.ssssksss_blog.blog.service
 * FileName : UserService
 * Author : 이 수 경
 * Date : 2022-04-03
 * Description :
 */
@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity signup(UserDto userDto) {
//        userRepository.saveUser(userDto.getName(),userDto.getPassword(),userDto.getEmail());
        return ResponseEntity.ok().body(new ResponseStatusDto(200,"Post Success"));
    }
}
