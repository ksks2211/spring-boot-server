package org.iptime.yoon.springbootserver.domain;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.iptime.yoon.springbootserver.domain.enums.BoardType;
import org.iptime.yoon.springbootserver.domain.security.UserEntity;
import org.iptime.yoon.springbootserver.repository.BoardRepository;
import org.iptime.yoon.springbootserver.repository.UserEntityRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author rival
 * @since 2022-03-17
 */
@DataJpaTest
class BoardTest {

    private final String boardTestTitle = "Test";
    private final String email = "test@gmail.com";

    @Autowired
    UserEntityRepository userEntityRepository;

    @Autowired
    BoardRepository boardRepository;

    @BeforeEach
    public void init() {
        UserEntity user = UserEntity.builder()
            .username("james")
            .password("1111")
            .email(email)
            .build();
        userEntityRepository.save(user);

        Board board = Board.builder()
            .title(boardTestTitle)
            .subTitle("sub-title")
            .content("content")
            .boardType(BoardType.FREE)
            .user(user)
            .build();
        boardRepository.save(board);
    }


    @Test
    public void entity_생성_확인하기() {

        UserEntity user = userEntityRepository.findByEmail(email).orElseThrow();

        assertThat(user.getUsername()).isEqualTo("james");
        assertThat(user.getPassword()).isEqualTo("1111");
        assertThat(user.getEmail()).isEqualTo(email);

        Board board = boardRepository.findByUser(user).get(0);

        assertThat(board.getTitle()).isEqualTo(boardTestTitle);
        assertThat(board.getSubTitle()).isEqualTo("sub-title");
        assertThat(board.getContent()).isEqualTo("content");
        assertThat(board.getBoardType()).isEqualTo(BoardType.FREE);
    }
}