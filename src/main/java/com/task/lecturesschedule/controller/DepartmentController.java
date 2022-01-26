package com.task.lecturesschedule.controller;

import com.task.lecturesschedule.dto.mapper.DepartmentMapper;
import com.task.lecturesschedule.dto.request.DepartmentRequestDto;
import com.task.lecturesschedule.dto.response.DepartmentResponseDto;
import com.task.lecturesschedule.model.Department;
import com.task.lecturesschedule.service.DepartmentService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/departments")
@AllArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;
    private final DepartmentMapper departmentMapper;

    @PostMapping
    public DepartmentResponseDto add(@RequestBody DepartmentRequestDto dto) {
        Department department = departmentService.add(departmentMapper.mapToModel(dto));
        return departmentMapper.mapToDto(department);
    }

    @GetMapping("/get/{id}")
    public DepartmentResponseDto get(@PathVariable Long id) {
        return departmentMapper.mapToDto(departmentService.get(id));
    }

    @GetMapping
    public List<DepartmentResponseDto> getAll() {
        return departmentService.getAll().stream()
                .map(departmentMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/update/{id}")
    public DepartmentResponseDto update(@PathVariable Long id,
                                        @RequestBody DepartmentRequestDto dto) {
        Department department = departmentService.get(id);
        department.setName(dto.getName());
        department.setFaculty(dto.getFaculty());
        return departmentMapper.mapToDto(departmentService.update(department));
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        departmentService.delete(id);
    }
}
