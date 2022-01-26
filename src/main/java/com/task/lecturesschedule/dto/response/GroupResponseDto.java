package com.task.lecturesschedule.dto.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GroupResponseDto {
    private Long id;
    private String name;
    private String specialization;
    private Long departmentId;
}
