package com.exam_qr.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "first_exam")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class FirstExam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    private Double result;
    private Boolean pass;

    @Column(columnDefinition = "TEXT")
    private String secondExamQrUrl;


}
