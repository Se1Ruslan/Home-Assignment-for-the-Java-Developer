package com.example.reverseproject.it;

import org.testcontainers.containers.GenericContainer;

public class ReverseProjectContainer extends GenericContainer<ReverseProjectContainer> {
    public static final String DOCKER_IMAGE_NAME = "kozak/reverse-project:latest";

    public ReverseProjectContainer() {
        super(DOCKER_IMAGE_NAME);
    }
}
