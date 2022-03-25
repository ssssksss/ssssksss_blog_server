package com.example.ssssksss_blog.blog.service;

import com.example.ssssksss_blog.blog.dao.Post;
import com.example.ssssksss_blog.blog.dao.SecondCategory;
import com.example.ssssksss_blog.blog.dto.PostDto;
import com.example.ssssksss_blog.blog.repository.PostRepository;
import com.example.ssssksss_blog.commonDto.ResponseDataDto;
import com.example.ssssksss_blog.commonDto.ResponseStatusDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

/**
 * PackageName : com.example.ssssksss_blog.blog.service
 * FileName : PostService
 * Author : 이 수 경
 * Date : 2022-03-13
 * Description :
 */

@Service
public class PostService {

    private PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public ResponseEntity addPost(PostDto postDto) {
        postRepository.savePost(postDto.getTitle(), postDto.getDescription(), postDto.getContent(), postDto.getSecondHref());
        return ResponseEntity.ok().body(new ResponseStatusDto(200,"Post Success"));
    }

    public ResponseEntity readPost(String fullHref) {
        Optional<List<Post>> optionalPosts = postRepository.findPostList(fullHref);
        if(optionalPosts.isEmpty()){
            return ResponseEntity.ok().body(new ResponseStatusDto(200,"아무런 내용이 없습니다."));
        }
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("posts", optionalPosts.get());
        return ResponseEntity.ok().body(new ResponseDataDto("read success",hashMap));
    }

    public ResponseEntity viewPost(String fullHref, int id) {
        Optional<Post> optionalPost = postRepository.findPost(fullHref,id);
        if(optionalPost.isEmpty()){
            return ResponseEntity.ok().body(new ResponseStatusDto(200,"아무런 내용이 없습니다."));
        }
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("post", optionalPost.get());
        return ResponseEntity.ok().body(new ResponseDataDto("read success",hashMap));
    }

    public ResponseEntity removePost(Long id) {
        postRepository.deleteById(id);
        return ResponseEntity.ok().body(new ResponseStatusDto(200,"Post Success"));
    }

    public ResponseEntity updatePost(PostDto postDto) {
        System.out.println(postDto.toString());
        postRepository.updatePost(Long.parseLong(String.valueOf(postDto.getId())),postDto.getTitle(),
                postDto.getDescription(),postDto.getContent());
        return ResponseEntity.ok().body(new ResponseStatusDto(200,"Post Update Success"));
    }
}
