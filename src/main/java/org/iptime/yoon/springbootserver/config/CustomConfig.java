package org.iptime.yoon.springbootserver.config;

import org.iptime.yoon.springbootserver.domain.Board;
import org.iptime.yoon.springbootserver.domain.enums.BoardType;
import org.iptime.yoon.springbootserver.domain.security.UserEntity;
import org.iptime.yoon.springbootserver.repository.BoardRepository;
import org.iptime.yoon.springbootserver.repository.UserEntityRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.stream.IntStream;

/**
 * @author rival
 * @since 2022-03-17
 */
@Configuration
public class CustomConfig {

    @Bean
    public CommandLineRunner runner(UserEntityRepository userEntityRepository, BoardRepository boardRepository) {

        return args -> {
            UserEntity user = UserEntity.builder()
                .username("james")
                .password("1111")
                .email("test@gmail.com")
                .build();
            userEntityRepository.save(user);

            IntStream.rangeClosed(1, 200).forEach(i ->
                boardRepository.save(
                    Board.builder()
                        .title("게시글" + i)
                        .subTitle("순서 " + i)
                        .content("content")
                        .boardType(BoardType.FREE)
                        .user(user)
                        .build()
                )
            );
        };
    }

}
