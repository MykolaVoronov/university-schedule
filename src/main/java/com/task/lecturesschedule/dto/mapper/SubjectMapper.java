package com.task.lecturesschedule.dto.mapper;

import com.task.lecturesschedule.dto.request.SubjectRequestDto;
import com.task.lecturesschedule.dto.response.SubjectResponseDto;
import com.task.lecturesschedule.model.Subject;
import org.springframework.stereotype.Component;

@Component
public class SubjectMapper implements ResponseDtoMapper<SubjectResponseDto, Subject>,
        RequestDtoMapper<SubjectRequestDto, Subject> {
    @Override
    public Subject mapToModel(SubjectRequestDto dto) {
        Subject subject = new Subject();
        subject.setName(dto.getName());
        return subject;
    }

    @Override
    public SubjectResponseDto mapToDto(Subject subject) {
        SubjectResponseDto dto = new SubjectResponseDto();
        dto.setId(subject.getId());
        dto.setName(subject.getName());
        return dto;
    }
}
