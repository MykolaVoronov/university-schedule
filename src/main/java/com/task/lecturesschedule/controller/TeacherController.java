package com.task.lecturesschedule.controller;

import com.task.lecturesschedule.dto.mapper.TeacherMapper;
import com.task.lecturesschedule.dto.request.TeacherRequestDto;
import com.task.lecturesschedule.dto.response.TeacherResponseDto;
import com.task.lecturesschedule.model.Subject;
import com.task.lecturesschedule.model.Teacher;
import com.task.lecturesschedule.service.DepartmentService;
import com.task.lecturesschedule.service.SubjectService;
import com.task.lecturesschedule.service.TeacherService;
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
@RequestMapping("/teachers")
@AllArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;
    private final TeacherMapper teacherMapper;
    private final DepartmentService departmentService;
    private final SubjectService subjectService;

    @PostMapping
    public TeacherResponseDto add(@RequestBody TeacherRequestDto dto) {
        Teacher teacher = teacherService.add(teacherMapper.mapToModel(dto));
        return teacherMapper.mapToDto(teacher);
    }

    @GetMapping("/get/{id}")
    public TeacherResponseDto get(@PathVariable Long id) {
        return teacherMapper.mapToDto(teacherService.get(id));
    }

    @GetMapping
    public List<TeacherResponseDto> getAll() {
        return teacherService.getAll().stream()
                .map(teacherMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/update/{id}")
    public TeacherResponseDto update(@PathVariable Long id, @RequestBody TeacherRequestDto dto) {
        Teacher teacher = teacherService.get(id);
        teacher.setFirstName(dto.getFirstName());
        teacher.setLastName(dto.getLastName());
        teacher.setDepartment(departmentService.get(dto.getDepartmentId()));
        List<Subject> subjects = dto.getSubjectIds().stream()
                .map(subjectService::get)
                .collect(Collectors.toList());
        teacher.setSubjects(subjects);
        return teacherMapper.mapToDto(teacherService.update(teacher));
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        teacherService.delete(id);
    }
}
