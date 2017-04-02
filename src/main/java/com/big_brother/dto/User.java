package com.big_brother.dto;

import java.util.Set;

/**
 * Created by denysburlakov on 10.01.16.
 */
public class User {
    private Set<UserResponse> response;
    public User() {
    }

    public Set<UserResponse> getResponse() {
        return response;
    }
}

