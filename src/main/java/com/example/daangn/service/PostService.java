package com.example.daangn.service;

import com.example.daangn.Dto.PostDto;
import com.example.daangn.Repository.PostRepository;
import com.example.daangn.domain.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostService   {

    private final PostRepository postRepository;

    public List<PostDto> getAllPosts() {
        return ((List<Post>) postRepository.findAll())
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    private PostDto convertEntityToDto(Post post) {
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setContent(post.getContent());
        return postDto;
    }

    public Post uploadPost(Post post) {
        return postRepository.save(post);
    }
}
