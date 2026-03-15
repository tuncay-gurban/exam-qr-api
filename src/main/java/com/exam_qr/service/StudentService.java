package com.exam_qr.service;

import com.exam_qr.dto.StudentRequest;
import com.exam_qr.entity.Student;
import com.exam_qr.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final PasswordEncoder passwordEncoder;

    public void register(StudentRequest request) {
        Student student = Student.builder()
                .name(request.getName())
                .surname(request.getSurname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();
        studentRepository.save(student);
    }
}
