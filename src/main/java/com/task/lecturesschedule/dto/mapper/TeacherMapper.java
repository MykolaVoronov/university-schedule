package com.task.lecturesschedule.dto.mapper;

import com.task.lecturesschedule.dto.request.TeacherRequestDto;
import com.task.lecturesschedule.dto.response.TeacherResponseDto;
import com.task.lecturesschedule.model.Subject;
import com.task.lecturesschedule.model.Teacher;
import com.task.lecturesschedule.service.DepartmentService;
import com.task.lecturesschedule.service.SubjectService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class TeacherMapper implements ResponseDtoMapper<TeacherResponseDto, Teacher>,
        RequestDtoMapper<TeacherRequestDto, Teacher> {
    private final DepartmentService departmentService;
    private final SubjectService subjectService;

    public TeacherMapper(DepartmentService departmentService, SubjectService subjectService) {
        this.departmentService = departmentService;
        this.subjectService = subjectService;
    }

    @Override
    public Teacher mapToModel(TeacherRequestDto dto) {
        Teacher teacher = new Teacher();
        teacher.setFirstName(dto.getFirstName());
        teacher.setLastName(dto.getLastName());
        teacher.setDepartment(departmentService.get(dto.getDepartmentId()));
        List<Subject> subjects = dto.getSubjectIds().stream()
                .map(subjectService::get)
                .collect(Collectors.toList());
        teacher.setSubjects(subjects);
        return teacher;
    }

    @Override
    public TeacherResponseDto mapToDto(Teacher teacher) {
        TeacherResponseDto dto = new TeacherResponseDto();
        dto.setId(teacher.getId());
        dto.setFirstName(teacher.getFirstName());
        dto.setLastName(teacher.getLastName());
        dto.setDepartmentId(teacher.getDepartment().getId());
        List<Long> subjectsIds = teacher.getSubjects().stream()
                .map(Subject::getId)
                .collect(Collectors.toList());
        dto.setSubjectIds(subjectsIds);
        return dto;
    }
}
