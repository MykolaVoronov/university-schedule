package com.task.lecturesschedule.dto.mapper;

import com.task.lecturesschedule.dto.request.StudentRequestDto;
import com.task.lecturesschedule.dto.response.StudentResponseDto;
import com.task.lecturesschedule.model.Student;
import com.task.lecturesschedule.service.GroupService;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper implements ResponseDtoMapper<StudentResponseDto, Student>,
        RequestDtoMapper<StudentRequestDto, Student> {
    private final GroupService groupService;

    public StudentMapper(GroupService groupService) {
        this.groupService = groupService;
    }

    @Override
    public Student mapToModel(StudentRequestDto dto) {
        Student student = new Student();
        student.setFirstName(dto.getFirstName());
        student.setLastName(dto.getLastName());
        student.setGroup(groupService.get(dto.getGroupId()));
        return student;
    }

    @Override
    public StudentResponseDto mapToDto(Student student) {
        StudentResponseDto dto = new StudentResponseDto();
        dto.setId(student.getId());
        dto.setFirstName(student.getFirstName());
        dto.setLastName(student.getLastName());
        dto.setGroupId(student.getGroup().getId());
        return dto;
    }
}
