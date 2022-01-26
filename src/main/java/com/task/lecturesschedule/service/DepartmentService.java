package com.task.lecturesschedule.service;

import com.task.lecturesschedule.model.Department;
import java.util.List;

public interface DepartmentService {
    Department add(Department department);

    Department get(Long id);

    List<Department> getAll();

    Department update(Department department);

    void delete(Long id);
}
