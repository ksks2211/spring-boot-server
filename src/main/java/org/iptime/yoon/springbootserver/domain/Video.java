package org.iptime.yoon.springbootserver.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * @author rival
 * @since 2022-03-03
 */
@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Video {
    private Integer runtime;

    @Enumerated(EnumType.STRING)
    private Audio audio;

    public enum Audio{
        KOR,
        ENG
    }
}
