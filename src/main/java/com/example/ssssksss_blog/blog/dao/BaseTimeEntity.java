package com.example.ssssksss_blog.blog.dao;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * PackageName : com.example.ssssksss_blog.blog.dao
 * FileName : BaseTimeEntity
 * Author : 이 수 경
 * Date : 2022-04-29
 * Description :
 */
@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseTimeEntity {

    @Column(name="create_at", nullable = false, columnDefinition = "DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(name="modified_at", nullable = false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private LocalDateTime modifiedAt;

    @Column(name="delete_at", nullable = false, columnDefinition = "DATETIME NOT NULL DEFAULT '9999-12-31 23:59:59'")
    private LocalDateTime deleteAt;

    @Column(name="access_yn", nullable = false, columnDefinition = "tinyint(1) default 1")
    private Boolean accessYn;

}
