package com.task.lecturesschedule.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LectureHallRequestDto {
    private String name;
    private int capacity;
}
