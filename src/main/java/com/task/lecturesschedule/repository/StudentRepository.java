package com.task.lecturesschedule.repository;

import com.task.lecturesschedule.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
