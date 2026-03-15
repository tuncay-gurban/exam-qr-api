package com.exam_qr.controller;

import com.exam_qr.dto.RegisterRequest;
import com.exam_qr.dto.RegisterResponse;
import com.exam_qr.service.SecondExamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/secondExam")
@RequiredArgsConstructor
public class SecondExamController {
    private final SecondExamService secondExamService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request){
        try {
            RegisterResponse response = secondExamService.register(request);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            int status = Integer.parseInt(e.getMessage());
            return ResponseEntity.status(status).build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }


}
