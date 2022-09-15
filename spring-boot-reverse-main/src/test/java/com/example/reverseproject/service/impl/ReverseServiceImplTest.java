package com.example.reverseproject.service.impl;

import com.example.reverseproject.service.ReverseService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

/**
 * @author Igor Hnes on 14.09.2022.
 */
@SpringBootTest
class ReverseServiceImplTest {

    @Autowired
    private ReverseService reverseService;

    @Test
    void getReverse() {
        String text = "123";
        final String reversed = reverseService.reverse(text);
        Assertions.assertEquals("321", reversed);
    }
}
