package com.task.lecturesschedule.service.impl;

import com.task.lecturesschedule.model.Department;
import com.task.lecturesschedule.repository.DepartmentRepository;
import com.task.lecturesschedule.service.DepartmentService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentDao) {
        this.departmentRepository = departmentDao;
    }

    @Override
    public Department add(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department get(Long id) {
        return departmentRepository.getById(id);
    }

    @Override
    public List<Department> getAll() {
        return departmentRepository.findAll();
    }

    @Override
    public Department update(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public void delete(Long id) {
        departmentRepository.delete(get(id));
    }
}
