package org.iptime.yoon.springbootserver.repository;

import org.iptime.yoon.springbootserver.domain.Post;
import org.iptime.yoon.springbootserver.domain.enums.PostType;
import org.iptime.yoon.springbootserver.security.domain.UserEntity;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author rival
 * @since 2022-03-22
 */

@DataJpaTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PostRepositoryTest {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserEntityRepository userEntityRepository;

    private UserEntity user;

    @BeforeAll
    public void init() {
        user = userEntityRepository.save(UserEntity.builder()
            .email("user@email.com")
            .password("password")
            .username("user")
            .build());

        IntStream.rangeClosed(0, 20).forEach(i -> postRepository.save(
            Post.builder()
                .title(i + " post")
                .postType(PostType.FREE)
                .content("content " + i)
                .user(user).build()
        ));
    }

    @Test
    public void paging_test() {
        Pageable pageable = PageRequest.of(0, 10);

        Page<Post> posts = postRepository.findByUser(user, pageable);
        posts.stream().forEach(System.out::println);
        assertThat(posts).hasSize(10);

    }
}