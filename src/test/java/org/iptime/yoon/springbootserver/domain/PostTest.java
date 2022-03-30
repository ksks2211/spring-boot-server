package org.iptime.yoon.springbootserver.domain;


import org.iptime.yoon.springbootserver.domain.enums.PostType;
import org.iptime.yoon.springbootserver.repository.PostRepository;
import org.iptime.yoon.springbootserver.security.repository.UserEntityRepository;
import org.iptime.yoon.springbootserver.security.domain.UserEntity;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author rival
 * @since 2022-03-17
 */
@DataJpaTest
class PostTest {

    private final String boardTestTitle = "Test";
    private final String email = "test@gmail.com";

    @Autowired
    UserEntityRepository userEntityRepository;

    @Autowired
    PostRepository postRepository;

    @BeforeEach
    public void init() {
        UserEntity user = UserEntity.builder()
            .username("james")
            .password("1111")
            .email(email)
            .build();
        userEntityRepository.save(user);

        Post post = Post.builder()
            .title(boardTestTitle)
            .subTitle("sub-title")
            .content("content")
            .postType(PostType.FREE)
            .user(user)
            .build();
        postRepository.save(post);
    }


    @Test
    public void entity_creation_test() {

        UserEntity user = userEntityRepository.findByEmail(email).orElseThrow();

        assertThat(user.getUsername()).isEqualTo("james");
        assertThat(user.getPassword()).isEqualTo("1111");
        assertThat(user.getEmail()).isEqualTo(email);

        Post post = postRepository.findByUser(user).get(0);

        assertThat(post.getTitle()).isEqualTo(boardTestTitle);
        assertThat(post.getSubTitle()).isEqualTo("sub-title");
        assertThat(post.getContent()).isEqualTo("content");
        assertThat(post.getPostType()).isEqualTo(PostType.FREE);
    }
}