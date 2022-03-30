package org.iptime.yoon.springbootserver.security.domain.enums;

import java.util.EnumSet;
import java.util.Set;

/**
 * @author rival
 * @since 2022-03-23
 */
public enum Role {
    ADMIN("ROLE_ADMIN", EnumSet.allOf(Privilege.class)), USER("ROLE_USER",EnumSet.of(Privilege.READ));

    private final String role;
    private final Set<Privilege> privileges;

    Role(String role, Set<Privilege> privileges) {
        this.role = role;
        this.privileges = privileges;
    }

    public String getRole(){
        return  role;
    }

    public String getValue(){
        return role;
    }

    public Set<Privilege> getPrivileges(){
        return this.privileges;
    }
}
