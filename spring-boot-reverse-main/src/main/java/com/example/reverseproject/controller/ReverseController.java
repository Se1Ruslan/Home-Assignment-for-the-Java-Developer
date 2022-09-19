package com.example.reverseproject.controller;

import com.example.reverseproject.service.ReverseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/reverse")
@RequiredArgsConstructor
public class ReverseController {
    private final ReverseService reverseService;

    @GetMapping
    public ResponseEntity<String> reverse(@RequestParam String text) {
        log.info("Handled reversing request. text = {}", text);
        String reversedText = reverseService.reverse(text);
        log.info("Reversing was ended for text = {}; reversedText = {};", text, reversedText);
        return ResponseEntity.ok(reversedText);
    }
}
