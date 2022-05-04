package com.example.ssssksss_blog.blog.dto;

import lombok.*;

/**
 * PackageName : com.example.ssssksss_blog.blog.dto
 * FileName : TokenDto
 * Author : 이 수 경
 * Date : 2022-04-27
 * Description :
 */
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@ToString
public class TokenDto {
    private String email;
    private String role;
}
