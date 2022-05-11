package com.example.ssssksss_blog.blog.dao;

import lombok.*;

import javax.persistence.*;

/**
 * PackageName : com.example.ssssksss_blog.blog.dto
 * FileName : PostContent
 * Author : 이 수 경
 * Date : 2022-05-04
 * Description :
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="post_content")
public class PostContent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, columnDefinition = "MEDIUMTEXT")
    private String content;

    @OneToOne(mappedBy = "postContent")
    private Post post;
}
