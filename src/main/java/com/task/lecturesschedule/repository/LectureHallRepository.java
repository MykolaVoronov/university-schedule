package com.task.lecturesschedule.repository;

import com.task.lecturesschedule.model.LectureHall;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LectureHallRepository extends JpaRepository<LectureHall, Long> {
}
