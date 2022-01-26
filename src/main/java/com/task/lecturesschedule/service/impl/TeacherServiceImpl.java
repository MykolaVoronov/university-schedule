package com.task.lecturesschedule.service.impl;

import com.task.lecturesschedule.model.Teacher;
import com.task.lecturesschedule.repository.TeacherRepository;
import com.task.lecturesschedule.service.TeacherService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository teacherRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public Teacher add(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public Teacher get(Long id) {
        return teacherRepository.getById(id);
    }

    @Override
    public List<Teacher> getAll() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher update(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public void delete(Long id) {
        teacherRepository.delete(get(id));
    }
}
