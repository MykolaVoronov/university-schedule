package com.task.lecturesschedule.service;

import com.task.lecturesschedule.model.Subject;
import java.util.List;

public interface SubjectService {
    Subject add(Subject subject);

    Subject get(Long id);

    List<Subject> getAll();

    Subject update(Subject subject);

    void delete(Long id);
}
