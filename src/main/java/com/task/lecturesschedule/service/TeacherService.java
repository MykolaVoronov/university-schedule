package com.task.lecturesschedule.service;

import com.task.lecturesschedule.model.Teacher;
import java.util.List;

public interface TeacherService {
    Teacher add(Teacher teacher);

    Teacher get(Long id);

    List<Teacher> getAll();

    Teacher update(Teacher teacher);

    void delete(Long id);
}
