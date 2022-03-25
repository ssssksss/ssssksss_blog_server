package com.example.ssssksss_blog.blog.dto;

import lombok.*;

/**
 * PackageName : com.example.ssssksss_blog.blog.dto
 * FileName : SecondCategoryDto
 * Author : 이 수 경
 * Date : 2022-03-16
 * Description :
 */

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SecondCategoryDto {
    private String name;
    private String secondHref;
    private String firstHref;
    private Integer position;
}
