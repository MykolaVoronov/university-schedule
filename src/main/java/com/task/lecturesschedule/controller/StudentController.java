package com.task.lecturesschedule.controller;

import com.task.lecturesschedule.dto.mapper.StudentMapper;
import com.task.lecturesschedule.dto.request.StudentRequestDto;
import com.task.lecturesschedule.dto.response.StudentResponseDto;
import com.task.lecturesschedule.model.Student;
import com.task.lecturesschedule.service.GroupService;
import com.task.lecturesschedule.service.StudentService;
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
@RequestMapping("/students")
@AllArgsConstructor
public class StudentController {
    private final StudentService studentService;
    private final StudentMapper studentMapper;
    private final GroupService groupService;

    @PostMapping
    public StudentResponseDto add(@RequestBody StudentRequestDto dto) {
        Student student = studentService.add(studentMapper.mapToModel(dto));
        return studentMapper.mapToDto(student);
    }

    @GetMapping("/get/{id}")
    public StudentResponseDto get(@PathVariable Long id) {
        return studentMapper.mapToDto(studentService.get(id));
    }

    @GetMapping
    public List<StudentResponseDto> getAll() {
        return studentService.getAll().stream()
                .map(studentMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/update/{id}")
    public StudentResponseDto update(@PathVariable Long id, @RequestBody StudentRequestDto dto) {
        Student student = studentService.get(id);
        student.setFirstName(dto.getFirstName());
        student.setLastName(dto.getLastName());
        student.setGroup(groupService.get(dto.getGroupId()));
        return studentMapper.mapToDto(studentService.update(student));
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        studentService.delete(id);
    }
}
