package com.task.lecturesschedule.repository;

import com.task.lecturesschedule.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
