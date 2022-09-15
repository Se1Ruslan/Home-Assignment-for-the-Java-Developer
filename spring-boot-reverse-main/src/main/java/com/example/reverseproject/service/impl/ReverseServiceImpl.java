package com.example.reverseproject.service.impl;

import com.example.reverseproject.service.ReverseService;
import org.springframework.stereotype.Service;

@Service
public class ReverseServiceImpl implements ReverseService {

    @Override
    public String reverse(String text) {
        if (text == null) {
            return null;
        }
        return new StringBuilder(text).reverse().toString();
    }
}
