package com.example.ssssksss_blog.blog.dao;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * PackageName : com.example.ssssksss_blog.blog.dao
 * FileName : Post
 * Author : 이 수 경
 * Date : 2022-03-13
 * Description :
 */

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String description;
    @Column(name="second_href", nullable = false)
    private String secondHref;
    @Column(nullable = false)
    private Integer position;
    @Column(name="like_number", nullable = false, columnDefinition = "int default 0")
    private Integer likeNumber;
    @Column(nullable = false, columnDefinition = "MEDIUMTEXT")
    private String content;
    @Column(name="modified_at", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private LocalDateTime modifiedAt;
    @Column(name="create_at", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createAt;
    @Column(name="access_yn", nullable = false, columnDefinition = "tinyint(1) default 1")
    private Boolean accessYn;
    @Column(name="user_id", nullable = false, columnDefinition = "varchar(255) default 'ssssksss'")
    private String userId;



}
