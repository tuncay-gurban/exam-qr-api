package com.exam_qr.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "second_exam")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class SecondExam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    private Double result;
    private Boolean pass;
}
