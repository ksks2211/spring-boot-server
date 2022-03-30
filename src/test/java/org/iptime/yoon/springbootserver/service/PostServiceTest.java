package org.iptime.yoon.springbootserver.service;

import org.iptime.yoon.springbootserver.domain.Post;
import org.iptime.yoon.springbootserver.domain.enums.PostType;
import org.iptime.yoon.springbootserver.security.domain.UserEntity;
import org.iptime.yoon.springbootserver.dto.PageRequestDto;
import org.iptime.yoon.springbootserver.dto.PostDto;
import org.iptime.yoon.springbootserver.dto.PostsResultDto;
import org.iptime.yoon.springbootserver.repository.PostRepository;
import org.iptime.yoon.springbootserver.security.repository.UserEntityRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author rival
 * @since 2022-03-17
 */
@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PostServiceTest {

    @Autowired
    PostService postService;
    @Autowired
    PostRepository postRepository;
    @Autowired
    UserEntityRepository userEntityRepository;


    private UserEntity user;

    @BeforeAll
    public void init() {
        user = UserEntity.builder()
            .email("user@email.com")
            .password("password")
            .username("user")
            .build();
        userEntityRepository.save(user);

        IntStream.rangeClosed(0, 20).forEach(i -> {
            Post post = Post.builder()
                .title(i + " post")
                .postType(PostType.FREE)
                .content("content " + i)
                .subTitle("Sub title")
                .user(user).build();
            postRepository.save(post);
        });

    }

    @Test
    void board_id_find_test(){

        PostDto post = postService.findPost(1L);
        System.out.println(post);
        assertThat(post).isNotNull();

    }

    @Test
    void board_page_find_test(){

        PageRequestDto pageRequestDto = PageRequestDto.builder()
            .page(1)
            .size(10)
            .build();

        PostsResultDto resultDto = postService.findPosts(pageRequestDto);

        // posts.getDtoList()

        List<PostDto> postDtoList = resultDto.getPosts();

        postDtoList.forEach(System.out::println);

        assertThat(postDtoList).hasSize(10);
    }



}