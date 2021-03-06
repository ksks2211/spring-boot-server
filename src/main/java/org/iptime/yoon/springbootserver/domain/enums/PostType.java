package org.iptime.yoon.springbootserver.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author rival
 * @since 2022-03-09
 */
@RequiredArgsConstructor
@Getter
public enum PostType {
    NOTICE("NOTICE"),
    FREE("FREE");

    private final String value;
}
