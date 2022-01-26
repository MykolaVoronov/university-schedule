package com.task.lecturesschedule.dto.mapper;

import com.task.lecturesschedule.dto.request.DepartmentRequestDto;
import com.task.lecturesschedule.dto.response.DepartmentResponseDto;
import com.task.lecturesschedule.model.Department;
import org.springframework.stereotype.Component;

@Component
public class DepartmentMapper implements ResponseDtoMapper<DepartmentResponseDto, Department>,
        RequestDtoMapper<DepartmentRequestDto, Department> {

    @Override
    public Department mapToModel(DepartmentRequestDto dto) {
        Department department = new Department();
        department.setName(dto.getName());
        department.setFaculty(dto.getFaculty());
        return department;
    }

    @Override
    public DepartmentResponseDto mapToDto(Department department) {
        DepartmentResponseDto dto = new DepartmentResponseDto();
        dto.setId(department.getId());
        dto.setName(department.getName());
        dto.setFaculty(department.getFaculty());
        return dto;
    }
}
