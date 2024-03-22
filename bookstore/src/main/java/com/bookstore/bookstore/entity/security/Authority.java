package com.bookstore.bookstore.entity.security;

import org.springframework.GrantedAuthority;
public class Authority implements GrantedAuthority{
    private final String authority;

    public Authority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority;
    }
}
