package com.task.lecturesschedule.controller;

import com.task.lecturesschedule.dto.mapper.SubjectMapper;
import com.task.lecturesschedule.dto.request.SubjectRequestDto;
import com.task.lecturesschedule.dto.response.SubjectResponseDto;
import com.task.lecturesschedule.model.Subject;
import com.task.lecturesschedule.service.SubjectService;
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
@RequestMapping("/subjects")
@AllArgsConstructor
public class SubjectController {
    private final SubjectService subjectService;
    private final SubjectMapper subjectMapper;

    @PostMapping
    public SubjectResponseDto add(@RequestBody SubjectRequestDto dto) {
        Subject subject = subjectService.add(subjectMapper.mapToModel(dto));
        return subjectMapper.mapToDto(subject);
    }

    @GetMapping("/get/{id}")
    public SubjectResponseDto get(@PathVariable Long id) {
        return subjectMapper.mapToDto(subjectService.get(id));
    }

    @GetMapping
    public List<SubjectResponseDto> getAll() {
        return subjectService.getAll().stream()
                .map(subjectMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/update/{id}")
    public SubjectResponseDto update(@PathVariable Long id, @RequestBody SubjectRequestDto dto) {
        Subject subject = subjectService.get(id);
        subject.setName(dto.getName());
        return subjectMapper.mapToDto(subjectService.update(subject));
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        subjectService.delete(id);
    }
}
