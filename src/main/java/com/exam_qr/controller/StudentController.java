package com.exam_qr.controller;

import com.exam_qr.dto.StudentRequest;
import com.exam_qr.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody StudentRequest request) {
        studentService.register(request);
        return ResponseEntity.ok().build();
    }
}

