package com.task.lecturesschedule.service.impl;

import com.task.lecturesschedule.model.Lecture;
import com.task.lecturesschedule.repository.LectureRepository;
import com.task.lecturesschedule.service.LectureService;
import com.task.lecturesschedule.service.StudentService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class LectureServiceImpl implements LectureService {
    private final LectureRepository lectureRepository;
    private final StudentService studentService;

    public LectureServiceImpl(LectureRepository lectureRepository, StudentService studentService) {
        this.lectureRepository = lectureRepository;
        this.studentService = studentService;
    }

    @Override
    public Lecture add(Lecture lecture) {
        return lectureRepository.save(lecture);
    }

    @Override
    public Lecture get(Long id) {
        return lectureRepository.getById(id);
    }

    @Override
    public List<Lecture> getAll() {
        return lectureRepository.findAll();
    }

    @Override
    public List<Lecture> findAllAvailableForStudent(Long id, LocalDate date) {
        Long groupId = studentService.get(id).getGroup().getId();
        return lectureRepository.findAvailableForGroup(groupId, date);
    }

    @Override
    public Lecture update(Lecture lecture) {
        return lectureRepository.save(lecture);
    }

    @Override
    public void delete(Long id) {
        lectureRepository.delete(get(id));
    }
}
