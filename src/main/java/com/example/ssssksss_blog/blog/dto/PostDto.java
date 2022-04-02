package com.example.ssssksss_blog.blog.dto;

import lombok.*;

import javax.persistence.Column;
import java.time.LocalDateTime;

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
    private String description;
    private String secondHref;
    private String content;
    private Integer position;
    private Integer likeNumber;
    private boolean accessYn;
    private String userId;
}
