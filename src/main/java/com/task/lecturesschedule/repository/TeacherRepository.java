package com.task.lecturesschedule.repository;

import com.task.lecturesschedule.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
