package com.example.ssssksss_blog.blog.dto;

import lombok.*;

/**
 * PackageName : com.example.ssssksss_blog.blog.dto
 * FileName : PostDto
 * Author : 이 수 경
 * Date : 2022-03-13
 * Description :
 */

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PostDto {
    private int id;
    private String title;
    private String content;
    private String secondHref;
    private String description;
}
