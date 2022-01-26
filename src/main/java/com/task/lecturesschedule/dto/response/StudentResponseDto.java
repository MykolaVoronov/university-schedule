package com.task.lecturesschedule.dto.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StudentResponseDto {
    private Long id;
    private String firstName;
    private String lastName;
    private Long groupId;
}
