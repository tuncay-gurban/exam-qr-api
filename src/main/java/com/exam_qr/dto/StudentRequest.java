package com.exam_qr.dto;

import lombok.Data;

@Data
public class StudentRequest {
    private String name;
    private String surname;
    private String email;
    private String password;
}
