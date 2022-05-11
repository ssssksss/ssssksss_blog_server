package com.example.ssssksss_blog.blog.service;

import com.example.ssssksss_blog.blog.dao.BaseTimeEntity;
import com.example.ssssksss_blog.blog.dao.Post;
import com.example.ssssksss_blog.blog.dao.PostContent;
import com.example.ssssksss_blog.blog.dao.PostList;
import com.example.ssssksss_blog.blog.dto.PostDto;
import com.example.ssssksss_blog.blog.repository.PostRepository;
import com.example.ssssksss_blog.commonDto.ResponseDataDto;
import com.example.ssssksss_blog.commonDto.ResponseStatusDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
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
        PostContent postContent = PostContent.builder().content(postDto.getContent()).build();
        Post post = Post.builder().title(postDto.getTitle()).description(postDto.getDescription())
                .secondHref(postDto.getSecondHref()).postContent(postContent).build();
        postRepository.save(post);
        return ResponseEntity.ok().body(new ResponseStatusDto(200, "Post Success"));
    }

    public ResponseEntity readPosts(String fullHref) {
        Optional<List<PostList>> optionalPosts = postRepository.findPostList(fullHref);
        if(optionalPosts.isEmpty()){
            return ResponseEntity.ok().body(new ResponseStatusDto(200,"아무런 내용이 없습니다."));
        }
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("posts", optionalPosts.get());
        return ResponseEntity.ok().body(new ResponseDataDto(200,"read success",hashMap));
    }

    @Transactional(readOnly = true)
    public ResponseEntity readPost(String fullHref, Long id) {
//        Optional<Post> optionalPost = postRepository.findPost(fullHref,id);
//        if(postRepository.isEmpty()){
//            return ResponseEntity.ok().body(new ResponseStatusDto(200,"아무런 내용이 없습니다."));
//        }
        if(!postRepository.existsBySecondHrefAndId(fullHref,id)) {
            return ResponseEntity.ok().body(new ResponseStatusDto(200,"아무런 내용이 없습니다."));
        } else {
          Post post = postRepository.findBySecondHrefAndId(fullHref,id);
            PostDto postDto = PostDto.builder()
                    .id(post.getId())
                    .userId(post.getUserId())
                    .description(post.getDescription())
                    .title(post.getTitle())
                    .likeNumber(post.getLikeNumber())
                    .content(post.getPostContent().getContent())
                    .modifiedAt(post.getBaseTimeEntity().getModifiedAt())
                    .build();
          HashMap<String,Object> hashMap = new HashMap<>();
          hashMap.put("post", postDto);

        return ResponseEntity.ok().body(new ResponseDataDto(200, "read success",hashMap));
        }
    }
    @Transactional
    public ResponseEntity removePost(Long id) {
        postRepository.deletePost(id);
        return ResponseEntity.ok().body(new ResponseStatusDto(200,"Post Success"));
    }

    @Transactional
    public ResponseEntity updatePost(PostDto postDto) {
//        id, title, description, content, secondHref
        Optional<Post> post = postRepository.findById(postDto.getId());
        post.get().setDescription(postDto.getDescription());
        post.get().setTitle(postDto.getTitle());
        PostContent postContent = post.get().getPostContent();
        postContent.setContent(postDto.getContent());
        post.get().setPostContent(postContent);
        postRepository.save(post.get());
        return ResponseEntity.ok().body(new ResponseStatusDto(200,"Post Update Success"));
    }

//    public ResponseEntity addPost(PostDto postDto) {
//        PostContent postContent = PostContent.builder().content(postDto.getContent()).build();
//        Post post = Post.builder().title(postDto.getTitle()).description(postDto.getDescription())
//                .secondHref(postDto.getSecondHref()).postContent(postContent).build();
//        postRepository.save(post);
//        return ResponseEntity.ok().body(new ResponseStatusDto(200, "Post Success"));
//    }
}
