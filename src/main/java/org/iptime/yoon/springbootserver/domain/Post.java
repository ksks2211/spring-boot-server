package org.iptime.yoon.springbootserver.domain;

import lombok.*;
import org.iptime.yoon.springbootserver.domain.enums.PostType;
import org.iptime.yoon.springbootserver.security.domain.UserEntity;

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
public class Post extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String title;

    private String subTitle;

    private String content;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private PostType postType = PostType.FREE;

    // 작성자
    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private UserEntity user;
}
