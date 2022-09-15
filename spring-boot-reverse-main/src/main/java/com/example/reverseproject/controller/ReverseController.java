package com.example.reverseproject.controller;

import com.example.reverseproject.service.ReverseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reverse")
public class ReverseController {

    @Autowired
    private ReverseService reverseService;

    @GetMapping
    public ResponseEntity<String> reverse(@RequestParam String text) {
        return ResponseEntity.ok(reverseService.reverse(text));
    }
}
