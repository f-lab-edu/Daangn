package com.example.daangn.Api;

import com.example.daangn.Dto.PostDto;
import com.example.daangn.domain.Post;
import com.example.daangn.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostApi {
    private final PostService postService;

    @GetMapping("/post")
    public List<PostDto> posts() {
        return postService.getAllPosts();
    }

    @PostMapping("/post")
    public ResponseEntity<Post> upload(PostDto postDto) {
        Post post = convertDtoToEntity(postDto);
        Post updatedPost = postService.uploadPost(post);
        return ResponseEntity.ok(postService.uploadPost(updatedPost));
    }

    private Post convertDtoToEntity(PostDto postDto) {
        Post post = new Post();
        post.setId(postDto.getId());
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        return post;
    }
}
