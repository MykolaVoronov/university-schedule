package com.task.lecturesschedule.service;

import com.task.lecturesschedule.model.Lecture;
import java.time.LocalDate;
import java.util.List;

public interface LectureService {
    Lecture add(Lecture lecture);

    Lecture get(Long id);

    List<Lecture> getAll();

    List<Lecture> findAllAvailableForStudent(Long id, LocalDate date);

    Lecture update(Lecture lecture);

    void delete(Long id);
}
