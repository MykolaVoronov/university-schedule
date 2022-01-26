package com.task.lecturesschedule.service;

import com.task.lecturesschedule.model.LectureHall;
import java.util.List;

public interface LectureHallService {
    LectureHall add(LectureHall lectureHall);

    LectureHall get(Long id);

    List<LectureHall> getAll();

    LectureHall update(LectureHall lectureHall);

    void delete(Long id);
}
