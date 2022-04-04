package com.example.ssssksss_blog.blog.dto;

import lombok.*;

/**
 * PackageName : com.example.ssssksss_blog.blog.dto
 * FileName : UserDto
 * Author : 이 수 경
 * Date : 2022-04-03
 * Description :
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDto {
    private String name;
    private String password;
    private String email;
}
