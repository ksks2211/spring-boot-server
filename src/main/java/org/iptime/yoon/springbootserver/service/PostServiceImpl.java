package org.iptime.yoon.springbootserver.service;

import lombok.RequiredArgsConstructor;
import org.iptime.yoon.springbootserver.domain.Post;
import org.iptime.yoon.springbootserver.dto.PageRequestDto;
import org.iptime.yoon.springbootserver.dto.PostDto;
import org.iptime.yoon.springbootserver.dto.PostsResultDto;
import org.iptime.yoon.springbootserver.repository.PostRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


/**
 * @author rival
 * @since 2022-03-17
 */
@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    public PostsResultDto findPosts(PageRequestDto requestDto) {
        Pageable pageable = requestDto.getPageable(Sort.by("id").descending());
        Page<Post> posts = postRepository.findAll(pageable);
        return new PostsResultDto(posts, this::entityToDto);
    }

    @Override
    public PostDto findPost(Long id) {

        return
            entityToDto(postRepository.findById(id).orElse(new Post()));
    }

    @Override
    public Long register(Post post) {
        return postRepository.save(post).getId();
    }

}
