package org.iptime.yoon.springbootserver.security.domain.enums;

/**
 * @author rival
 * @since 2022-03-23
 */
public enum Privilege {

    WRITE("WRITE_PRIVILEGE"), READ("READ_PRIVILEGE"), DELETE("DELETE_PRIVILEGE");

    private final String value;

    Privilege(String value){
        this.value=value;
    }
}
