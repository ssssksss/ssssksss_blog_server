package com.example.ssssksss_blog.blog.dao;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.lang.Nullable;

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
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="post")
@DynamicInsert
@DynamicUpdate
@ToString
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
    @Column(name="like_number", nullable = false, columnDefinition = "int default 0")
    private Integer likeNumber;
    @Column(name="user_id", nullable = false, columnDefinition = "varchar(255) default 'ssssksss'")
    private String userId;
    @Column(nullable = false, columnDefinition = "int default 0")
    private Integer position;
//
    @Embedded
    private BaseTimeEntity baseTimeEntity;

    @OneToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
    @JoinTable(name="POST_POST_CONTENT",
            joinColumns = @JoinColumn(name="POST_ID"),
            inverseJoinColumns = @JoinColumn(name="POST_CONTENT_ID")
    )
    private PostContent postContent;



}
