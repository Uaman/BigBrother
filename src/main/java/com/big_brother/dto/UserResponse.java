package com.big_brother.dto;

import com.big_brother.dto.serialization.NumericBooleanDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Set;

/**
 * Created by denysburlakov on 30.01.16.
 */
public class UserResponse {

    private Long id;
    @JsonProperty(value = "first_name")
    private String firstName;
    @JsonProperty(value = "last_name")
    private String lastName;
    @JsonDeserialize(using=NumericBooleanDeserializer.class)
    private boolean online;

    public UserResponse() {
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public boolean isOnline() {
        return online;
    }
}
