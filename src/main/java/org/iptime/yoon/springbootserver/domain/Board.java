package org.iptime.yoon.springbootserver.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.iptime.yoon.springbootserver.domain.enums.BoardType;
import org.iptime.yoon.springbootserver.domain.security.UserEntity;

import javax.persistence.*;

/**
 * @author rival
 * @since 2022-03-09
 */

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Board extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String subTitle;

    private String content;

    @Enumerated(EnumType.STRING)
    private BoardType boardType;

    // 작성자
    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity userEntity;
}
