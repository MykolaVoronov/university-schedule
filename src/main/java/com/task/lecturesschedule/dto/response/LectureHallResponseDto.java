package com.task.lecturesschedule.dto.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LectureHallResponseDto {
    private Long id;
    private String name;
    private int capacity;
}
