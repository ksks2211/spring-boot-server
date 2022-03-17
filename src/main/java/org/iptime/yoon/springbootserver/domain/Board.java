package org.iptime.yoon.springbootserver.domain;

import lombok.*;
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
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Board extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String subTitle;

    private String content;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private BoardType boardType = BoardType.FREE;

    // 작성자
    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private UserEntity user;
}
