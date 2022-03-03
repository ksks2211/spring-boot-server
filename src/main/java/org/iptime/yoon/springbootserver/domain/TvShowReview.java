package org.iptime.yoon.springbootserver.domain;

import lombok.*;

import javax.persistence.*;

/**
 * @author rival
 * @since 2022-03-03
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)// toString 호출시, 상위 클래스의 toString 포함
@EqualsAndHashCode(callSuper = true)
public class TvShowReview extends BaseEntity{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Review review;
}
