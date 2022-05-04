package com.example.ssssksss_blog.blog.dto;

import lombok.*;

/**
 * PackageName : com.example.ssssksss_blog.blog.dto
 * FileName : ViewDto
 * Author : 이 수 경
 * Date : 2022-04-30
 * Description :
 */
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@ToString
public class ViewDto {
    private static final long serialVersionUID = 1L;

    private Long todayView;
    private Long yesterdayView;
    private Long alldayView;
}
