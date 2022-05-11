package com.example.ssssksss_blog.blog.repository;

import com.example.ssssksss_blog.blog.dao.Post;
import com.example.ssssksss_blog.blog.dao.PostContent;
import com.example.ssssksss_blog.blog.dao.PostList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * PackageName : com.example.ssssksss_blog.blog.repository
 * FileName : PostRepository
 * Author : 이 수 경
 * Date : 2022-03-13
 * Description :
 */

public interface PostRepository extends JpaRepository<Post,Long> {
    @Modifying
    @Query(value = "insert into post (title, description, content, second_href, position) VALUES (:title,:description,:content,:second_href," +
        "(select count(temp.position)+1 from (select * from post where second_href = :second_href) as temp))"
            , nativeQuery = true)
    @Transactional
    void savePost(
            @Param("title") String title,
            @Param("description") String description,
            @Param("content") String content,
            @Param("second_href") String secondHref
    );


    @Modifying
    @Query(value = "select id,title,description,second_href,position,like_number,modified_at,access_yn,user_id" +
            " from post where second_href = :second_href and access_yn = 1", nativeQuery = true)
    @Transactional
    Optional<List<PostList>> findPostList(
            @Param("second_href") String secondHref
    );

//    @Query(value = "select * from post where second_href = :second_href and id = :id", nativeQuery = true)
//    Optional<Post> findPost(
//            @Param("second_href") String secondHref,
//            @Param("id") Long id
//    );
    Post findBySecondHrefAndId(String secondHref,Long id);
    Boolean existsBySecondHrefAndId(String secondHref,Long id);

    @Modifying
    @Query(value = "update post set access_yn = 1, post_content=:post_content ,description=:description, " +
            "title= :title where id= :id", nativeQuery = true)
    @Transactional
    void updatePost(
            @Param("id") Long id,
            @Param("title") String title,
            @Param("description") String description,
            @Param("post_content") PostContent postContent
    );

    @Modifying
    @Transactional
    @Query(value = "update post set access_yn=0, delete_at=now() where id=:id", nativeQuery = true)
//    실제로 삭제하지 않음
    void deletePost(
            @Param("id") Long id
    );

}
