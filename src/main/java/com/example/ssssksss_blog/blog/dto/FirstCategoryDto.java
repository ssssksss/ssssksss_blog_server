package com.example.ssssksss_blog.blog.dto;

import lombok.*;

/**
 * PackageName : com.example.ssssksss_blog.blog.dto
 * FileName : FirstCategoryDto
 * Author : 이 수 경
 * Date : 2022-03-16
 * Description :
 */

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FirstCategoryDto {
    private String name;
    private String firstHref;
    private Integer line;
    private Integer position;
    private String userId;
}
