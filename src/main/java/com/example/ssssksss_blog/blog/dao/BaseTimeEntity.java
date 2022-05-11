package com.example.ssssksss_blog.blog.dao;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * PackageName : com.example.ssssksss_blog.blog.dao
 * FileName : BaseTimeEntity
 * Author : 이 수 경
 * Date : 2022-04-29
 * Description :
 */
//@MappedSuperclass
//@EntityListeners(AuditingEntityListener.class)
@Embeddable
@Getter
@Setter
@DynamicUpdate
@DynamicInsert
public class BaseTimeEntity {

    @Column(name="create_at", nullable = false, columnDefinition = "DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(name="modified_at", nullable = false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private LocalDateTime modifiedAt;

    @Column(name="delete_at", nullable = false, columnDefinition = "DATETIME NOT NULL DEFAULT '9999-12-31 23:59:59'")
    private LocalDateTime deleteAt;

    @Column(name="access_yn", insertable = false ,nullable = false, columnDefinition = "tinyint(1) default 1")
    private Boolean accessYn;

}
