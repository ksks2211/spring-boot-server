package org.iptime.yoon.springbootserver.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

/**
 * @author rival
 * @since 2022-03-03
 */
@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {

    private Integer star;
    private String comment;
    private Boolean like;
}
