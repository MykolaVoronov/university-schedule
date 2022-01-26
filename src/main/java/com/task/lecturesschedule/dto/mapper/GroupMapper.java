package com.task.lecturesschedule.dto.mapper;

import com.task.lecturesschedule.dto.request.GroupRequestDto;
import com.task.lecturesschedule.dto.response.GroupResponseDto;
import com.task.lecturesschedule.model.Group;
import com.task.lecturesschedule.service.DepartmentService;
import org.springframework.stereotype.Component;

@Component
public class GroupMapper implements ResponseDtoMapper<GroupResponseDto, Group>,
        RequestDtoMapper<GroupRequestDto, Group> {
    private final DepartmentService departmentService;

    public GroupMapper(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @Override
    public Group mapToModel(GroupRequestDto dto) {
        Group group = new Group();
        group.setName(dto.getName());
        group.setSpecialization(dto.getSpecialization());
        group.setDepartment(departmentService.get(dto.getDepartmentId()));
        return group;
    }

    @Override
    public GroupResponseDto mapToDto(Group group) {
        GroupResponseDto dto = new GroupResponseDto();
        dto.setId(group.getId());
        dto.setName(group.getName());
        dto.setSpecialization(group.getSpecialization());
        dto.setDepartmentId(group.getDepartment().getId());
        return dto;
    }
}
