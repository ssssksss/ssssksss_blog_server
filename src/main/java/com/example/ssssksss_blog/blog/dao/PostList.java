package com.example.ssssksss_blog.blog.dao;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDateTime;

/**
 * PackageName : com.example.ssssksss_blog.blog.dao
 * FileName : PostList
 * Author : 이 수 경
 * Date : 2022-03-27
 * Description :
 */
public interface PostList {

    Long getId();
    String getTitle();
    String getDescription();
    String getSecond_href();
    Integer getPosition();
    Integer getLike_number();
    LocalDateTime getModified_at();
    Boolean getAccess_yn();
    String getUser_id();
}
