package com.exam_qr.repository;

import com.exam_qr.entity.FirstExam;
import com.exam_qr.entity.Student;
import org.hibernate.sql.model.internal.OptionalTableInsert;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FirstExamRepository extends JpaRepository<FirstExam,Long> {
    Optional<FirstExam> findByStudentId(Long studentId);
}
