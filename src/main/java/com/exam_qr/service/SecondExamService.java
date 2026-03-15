package com.exam_qr.service;

import com.exam_qr.dto.RegisterRequest;
import com.exam_qr.dto.RegisterResponse;
import com.exam_qr.entity.FirstExam;
import com.exam_qr.entity.SecondExam;
import com.exam_qr.entity.Student;
import com.exam_qr.repository.FirstExamRepository;
import com.exam_qr.repository.SecondExamRepository;
import com.exam_qr.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class SecondExamService {
    private final SecondExamRepository secondExamRepository;
    private final FirstExamRepository firstExamRepository;
    private final StudentRepository studentRepository;
    private final QRCodeService qrCodeService;
    private final EmailService emailService;
    private final PasswordEncoder passwordEncoder;

    public RegisterResponse register(RegisterRequest request)throws Exception{
        Student student = studentRepository.findByEmail(request.getEmail())
                .orElseThrow(()->new RuntimeException("401"));

        if(!passwordEncoder.matches(request.getPassword(), student.getPassword())){
            throw new RuntimeException("401");
        }

            FirstExam firstExam = firstExamRepository.findByStudentId(student.getId())
                    .orElseThrow(()->new RuntimeException("403"));

        if(!firstExam.getPass()) throw new RuntimeException("403");

        secondExamRepository.findByStudentId(student.getId())
                .ifPresent(s -> { throw new RuntimeException("409"); });

        SecondExam secondExam = SecondExam.builder()
                .student(student)
                .build();
        secondExamRepository.save(secondExam);

        String qrBase64 = qrCodeService.generateQRCode(student.getEmail());
        emailService.sendQRCode(student.getEmail(), qrBase64);
        firstExam.setSecondExamQrUrl(qrBase64);
        firstExamRepository.save(firstExam);

        return RegisterResponse.builder()
                .id(secondExam.getId())
                .name(student.getName())
                .surname(student.getSurname())
                .email(student.getEmail())
                .qrUrl(qrBase64)
                .build();
        }
}
