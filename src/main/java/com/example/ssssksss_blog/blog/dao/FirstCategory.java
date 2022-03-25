package com.example.ssssksss_blog.blog.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * PackageName : com.example.ssssksss_blog.blog.dao
 * FileName : CategoryFirst
 * Author : 이 수 경
 * Date : 2022-03-16
 * Description :
 */
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="first_category")
public class FirstCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(name="first_href", nullable = false, unique=true)
    private String firstHref;
    @Column(nullable = false)
    private int line;
    @Column(nullable = false)
    private int position;
    @Column(name="user_id", nullable = false, columnDefinition = "varchar(255) default 'ssssksss'")
    private String userId;
}
