package com.task.lecturesschedule.service;

import com.task.lecturesschedule.model.Student;
import java.util.List;

public interface StudentService {
    Student add(Student student);

    Student get(Long id);

    List<Student> getAll();

    Student update(Student student);

    void delete(Long id);
}
