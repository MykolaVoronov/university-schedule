package com.task.lecturesschedule.repository;

import com.task.lecturesschedule.model.Lecture;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LectureRepository extends JpaRepository<Lecture, Long> {
    @Query("SELECT l FROM Lecture l "
            + "JOIN FETCH l.group g "
            + "JOIN FETCH l.teacher t "
            + "JOIN FETCH l.lectureHall "
            + "JOIN FETCH l.subject "
            + "WHERE g.id = :id "
            + "AND l.startDate = :date")
    List<Lecture> findAvailableForGroup(Long id, LocalDate date);
}
