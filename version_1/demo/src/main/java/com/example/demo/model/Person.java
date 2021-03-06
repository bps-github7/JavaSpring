package com.example.demo.model;

import java.util.UUID;

//working on validation... this seems to be deprecated. or missing the javax package...
// import javax.annotation.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.lang.NonNull;

public class Person {
    private final UUID id;

    @NonNull
    private final String name;

    public Person(@JsonProperty("id") UUID id, @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
