package com.task.lecturesschedule.dto.mapper;

import com.task.lecturesschedule.dto.request.LectureHallRequestDto;
import com.task.lecturesschedule.dto.response.LectureHallResponseDto;
import com.task.lecturesschedule.model.LectureHall;
import org.springframework.stereotype.Component;

@Component
public class LectureHallMapper implements ResponseDtoMapper<LectureHallResponseDto, LectureHall>,
        RequestDtoMapper<LectureHallRequestDto, LectureHall> {
    @Override
    public LectureHall mapToModel(LectureHallRequestDto dto) {
        LectureHall lectureHall = new LectureHall();
        lectureHall.setName(dto.getName());
        lectureHall.setCapacity(dto.getCapacity());
        return lectureHall;
    }

    @Override
    public LectureHallResponseDto mapToDto(LectureHall lectureHall) {
        LectureHallResponseDto dto = new LectureHallResponseDto();
        dto.setId(lectureHall.getId());
        dto.setName(lectureHall.getName());
        dto.setCapacity(lectureHall.getCapacity());
        return dto;
    }
}
