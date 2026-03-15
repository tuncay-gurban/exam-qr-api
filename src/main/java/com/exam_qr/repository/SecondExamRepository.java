package com.exam_qr.repository;

import com.exam_qr.entity.SecondExam;
import com.exam_qr.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SecondExamRepository extends JpaRepository<SecondExam,Long> {
    Optional<SecondExam> findByStudentId(Long studentId);
}
