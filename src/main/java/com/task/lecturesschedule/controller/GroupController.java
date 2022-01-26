package com.task.lecturesschedule.controller;

import com.task.lecturesschedule.dto.mapper.GroupMapper;
import com.task.lecturesschedule.dto.request.GroupRequestDto;
import com.task.lecturesschedule.dto.response.GroupResponseDto;
import com.task.lecturesschedule.model.Group;
import com.task.lecturesschedule.service.DepartmentService;
import com.task.lecturesschedule.service.GroupService;
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
@RequestMapping("/groups")
@AllArgsConstructor
public class GroupController {
    private final GroupService groupService;
    private final GroupMapper groupMapper;
    private final DepartmentService departmentService;

    @PostMapping
    public GroupResponseDto add(@RequestBody GroupRequestDto dto) {
        Group group = groupService.add(groupMapper.mapToModel(dto));
        return groupMapper.mapToDto(group);
    }

    @GetMapping("/get/{id}")
    public GroupResponseDto get(@PathVariable Long id) {
        return groupMapper.mapToDto(groupService.get(id));
    }

    @GetMapping
    public List<GroupResponseDto> getAll() {
        return groupService.getAll().stream()
                .map(groupMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/update/{id}")
    public GroupResponseDto update(@PathVariable Long id, @RequestBody GroupRequestDto dto) {
        Group group = groupService.get(id);
        group.setName(dto.getName());
        group.setSpecialization(dto.getSpecialization());
        group.setDepartment(departmentService.get(dto.getDepartmentId()));
        return groupMapper.mapToDto(groupService.update(group));
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        groupService.delete(id);
    }
}

