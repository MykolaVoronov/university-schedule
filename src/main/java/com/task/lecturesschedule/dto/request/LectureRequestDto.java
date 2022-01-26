package com.task.lecturesschedule.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LectureRequestDto {
    private Long lectureHallId;
    private Long groupId;
    private Long subjectId;
    private Long teacherId;
    private String startDate;
}
