package com.example.ssssksss_blog.blog.repository;

import com.example.ssssksss_blog.blog.dao.Post;
import com.example.ssssksss_blog.blog.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * PackageName : com.example.ssssksss_blog.blog.repository
 * FileName : UserRepository
 * Author : 이 수 경
 * Date : 2022-04-03
 * Description :
 */
public interface UserRepository extends JpaRepository<User,Long> {
//    잠시 보류
//    void saveUser(String name, String password, String email);

}
