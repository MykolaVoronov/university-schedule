package com.task.lecturesschedule.service.impl;

import com.task.lecturesschedule.model.Subject;
import com.task.lecturesschedule.repository.SubjectRepository;
import com.task.lecturesschedule.service.SubjectService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class SubjectServiceImpl implements SubjectService {
    private final SubjectRepository subjectRepository;

    public SubjectServiceImpl(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public Subject add(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public Subject get(Long id) {
        return subjectRepository.getById(id);
    }

    @Override
    public List<Subject> getAll() {
        return subjectRepository.findAll();
    }

    @Override
    public Subject update(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public void delete(Long id) {
        subjectRepository.delete(get(id));
    }
}
