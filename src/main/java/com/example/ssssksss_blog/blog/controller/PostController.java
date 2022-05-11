package com.example.ssssksss_blog.blog.controller;

import com.example.ssssksss_blog.blog.dao.Post;
import com.example.ssssksss_blog.blog.dto.PostDto;
import com.example.ssssksss_blog.blog.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * PackageName : com.example.ssssksss_blog.blog.controller
 * FileName : BlogController
 * Author : 이 수 경
 * Date : 2022-03-13
 * Description :
 */

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;



//    포스트 생성
@RequestMapping(value="/ssssksss/post", method= RequestMethod.POST)
public ResponseEntity addPost(@RequestBody PostDto postDto) {
    return postService.addPost(postDto);
}

    //    포스트 1개 조회
    @RequestMapping(value="/ssssksss/post", method= RequestMethod.GET)
    public ResponseEntity viewPost(
            @RequestParam(name = "firstHref") String firstHref,
            @RequestParam(name = "secondHref") String secondHref,
            @RequestParam(name = "id") Long id
    ) {
        String fullHref = "/" + firstHref + "/" + secondHref;
        return postService.readPost(fullHref,id);
    }

    //    포스트 수정
    @RequestMapping(value="/ssssksss/post", method= RequestMethod.PUT)
    public ResponseEntity updatePost(@RequestBody PostDto postDto) {
        return postService.updatePost(postDto);
    }

//    포스트 삭제
@RequestMapping(value="/ssssksss/post", method= RequestMethod.DELETE)
public ResponseEntity removePost(@RequestBody PostDto postDto) {
    return postService.removePost(postDto.getId());
}



//    포스트 전체 조회
@RequestMapping(value="/ssssksss/posts", method= RequestMethod.GET)
public ResponseEntity readPost(
        @RequestParam(name = "firstHref") String firstHref,
        @RequestParam(name = "secondHref") String secondHref
) {
    String fullHref = "/" + firstHref + "/" + secondHref;
    return postService.readPosts(fullHref);
}
}

