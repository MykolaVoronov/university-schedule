package com.task.lecturesschedule.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StudentRequestDto {
    private String firstName;
    private String lastName;
    private Long groupId;
}
