package com.task.lecturesschedule.service.impl;

import com.task.lecturesschedule.model.LectureHall;
import com.task.lecturesschedule.repository.LectureHallRepository;
import com.task.lecturesschedule.service.LectureHallService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class LectureHallServiceImpl implements LectureHallService {
    private final LectureHallRepository lectureHallRepository;

    public LectureHallServiceImpl(LectureHallRepository lectureHallRepository) {
        this.lectureHallRepository = lectureHallRepository;
    }

    @Override
    public LectureHall add(LectureHall lectureHall) {
        return lectureHallRepository.save(lectureHall);
    }

    @Override
    public LectureHall get(Long id) {
        return lectureHallRepository.getById(id);
    }

    @Override
    public List<LectureHall> getAll() {
        return lectureHallRepository.findAll();
    }

    @Override
    public LectureHall update(LectureHall lectureHall) {
        return lectureHallRepository.save(lectureHall);
    }

    @Override
    public void delete(Long id) {
        lectureHallRepository.delete(get(id));
    }
}
