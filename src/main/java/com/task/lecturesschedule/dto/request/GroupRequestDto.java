package com.task.lecturesschedule.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GroupRequestDto {
    private String name;
    private String specialization;
    private Long departmentId;
}
