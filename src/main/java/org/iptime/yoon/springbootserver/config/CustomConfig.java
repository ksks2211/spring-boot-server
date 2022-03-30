package org.iptime.yoon.springbootserver.config;

import org.iptime.yoon.springbootserver.domain.Post;
import org.iptime.yoon.springbootserver.domain.enums.PostType;
import org.iptime.yoon.springbootserver.security.domain.UserEntity;
import org.iptime.yoon.springbootserver.repository.PostRepository;
import org.iptime.yoon.springbootserver.security.repository.UserEntityRepository;
import org.iptime.yoon.springbootserver.security.domain.UserRole;
import org.iptime.yoon.springbootserver.security.domain.enums.Role;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author rival
 * @since 2022-03-17
 */
@Configuration
public class CustomConfig {

    @Bean
    public CommandLineRunner runner(UserEntityRepository userEntityRepository, PostRepository postRepository) {

        return args -> {
            UserEntity user = UserEntity.builder()
                .username("james")
                .password("1111")
                .email("test@gmail.com")
                .build();


            user.getRoles().add(new UserRole(Role.USER,user));
            userEntityRepository.save(user);


            List<Post> posts = IntStream.rangeClosed(1, 50).asLongStream().mapToObj(i -> Post.builder()
                .title("게시글" + i)
                .subTitle("순서 " + i)
                .content("content")
                .postType(PostType.FREE)
                .user(user)
                .build()
            ).collect(Collectors.toList());
            postRepository.saveAll(posts);

        };
    }

}
