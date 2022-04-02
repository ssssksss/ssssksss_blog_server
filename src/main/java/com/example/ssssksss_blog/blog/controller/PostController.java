package com.example.ssssksss_blog.blog.controller;

import com.example.ssssksss_blog.blog.dao.Post;
import com.example.ssssksss_blog.blog.dto.PostDto;
import com.example.ssssksss_blog.blog.service.PostService;
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
@RequestMapping(value="/ssssksss/post/add", method= RequestMethod.POST)
public ResponseEntity addPost(@RequestBody PostDto postDto) {
    return postService.addPost(postDto);
}
//    포스트 전체 조회
@RequestMapping(value="/ssssksss/post/read", method= RequestMethod.GET)
public ResponseEntity readPost(
        @RequestParam(name = "firstHref") String firstHref,
        @RequestParam(name = "secondHref") String secondHref
) {
    String fullHref = "/" + firstHref + "/" + secondHref;
    System.out.println("fullHref : " + fullHref);
    return postService.arrayPost(fullHref);
}
//    포스트 1개 조회
@RequestMapping(value="/ssssksss/post/view", method= RequestMethod.GET)
public ResponseEntity viewPost(
        @RequestParam(name = "firstHref") String firstHref,
        @RequestParam(name = "secondHref") String secondHref,
        @RequestParam(name = "id") int id
) {
    String fullHref = "/" + firstHref + "/" + secondHref;
    return postService.viewPost(fullHref,id);
}
//    포스트 삭제
@RequestMapping(value="/ssssksss/post/remove", method= RequestMethod.POST)
public ResponseEntity removePost(@RequestBody HashMap<String,Object> obj) {
    Long id = Long.parseLong(String.valueOf(obj.get("id")));
    return postService.removePost(id);
}
//    포스트 수정
@RequestMapping(value="/ssssksss/post/update", method= RequestMethod.POST)
public ResponseEntity updatePost(@RequestBody PostDto postDto) {
    return postService.updatePost(postDto);
}
//

}
