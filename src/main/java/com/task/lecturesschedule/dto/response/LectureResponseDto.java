package com.task.lecturesschedule.dto.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LectureResponseDto {
    private Long id;
    private Long lectureHallId;
    private Long groupId;
    private Long subjectId;
    private Long teacherId;
    private String startDate;
}
