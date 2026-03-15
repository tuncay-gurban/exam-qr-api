package com.exam_qr.dto;

import com.exam_qr.entity.Student;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterResponse {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String qrUrl;
}
