package com.example.ssssksss_blog.blog.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * PackageName : com.example.ssssksss_blog.blog.dao
 * FileName : User
 * Author : 이 수 경
 * Date : 2022-04-03
 * Description :
 */

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="user")
@DynamicUpdate
@DynamicInsert
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true, columnDefinition = "varchar(255)")
    private String cuid;
    @Column(nullable = false, columnDefinition = "varchar(255) DEFAULT 'null'")
    @Builder.Default private String suid="null";
    @Column(nullable = false)
    private String password;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false, columnDefinition = "varchar(2)")
    private String gender;
    @Column(nullable = false)
    private String birthDate;
    @Column( nullable = false, columnDefinition = "varchar(255) NOT NULL default 'member'")
    @Builder.Default private String role = "member";
    @Column(name="login_count", nullable = false)
    @Builder.Default private int loginCount = 0;
    @Column(name="email_verification", nullable = false, columnDefinition = "tinyint(1) NOT NULL default 0")
    @Builder.Default private Boolean emailVerification = false;

    @Embedded
    private BaseTimeEntity baseTimeEntity;
}



//    CREATE TABLE `데이터베이스명`.`테이블명` (
//        `id` BIGINT NOT NULL AUTO_INCREMENT,
//        `cuid` VARCHAR(255) NOT NULL DEFAULT 'null',
//        `suid` VARCHAR(255) NOT NULL DEFAULT 'null',
//        `password` VARCHAR(255) NOT NULL,
//        `email` VARCHAR(255) NOT NULL,
//        `gender` VARCHAR(2) NOT NULL,
//        `create_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
//        `access_yn` TINYINT(1) NOT NULL DEFAULT '1',
//        `delete_at` DATETIME NOT NULL DEFAULT '9999-12-31 23:59:59',
//        PRIMARY KEY (`id`));

