package com.bookstore.bookstore.entity.security;

import org.springframework.security.core.GrantedAuthority;

/**
 * Represents an authority granted to a user in the system.
 */
public class Authority implements GrantedAuthority {
    private final String authority;

    /**
     * Constructs an Authority object with the specified authority.
     * @param authority the authority granted to the user
     */
    public Authority(String authority) {
        this.authority = authority;
    }

    /**
     * Gets the authority granted to the user.
     * @return the authority
     */
    @Override
    public String getAuthority() {
        return authority;
    }
}
