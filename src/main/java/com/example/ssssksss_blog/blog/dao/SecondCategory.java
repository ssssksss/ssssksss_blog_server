package com.example.ssssksss_blog.blog.dao;

import lombok.*;

import javax.persistence.*;

/**
 * PackageName : com.example.ssssksss_blog.blog.dao
 * FileName : SecondaryCategory
 * Author : 이 수 경
 * Date : 2022-03-17
 * Description :
 */

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="second_category")
public class SecondCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String firstHref;
    @Column(name="second_href",nullable = false, unique=true)
    private String secondHref;
    @Column(nullable = false)
    private int position;
    @Column(name="user_id", nullable = false, columnDefinition = "varchar(255) default 'ssssksss'")
    private String userId;

}
