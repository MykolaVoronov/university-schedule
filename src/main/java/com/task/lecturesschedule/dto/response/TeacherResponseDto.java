package com.task.lecturesschedule.dto.response;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TeacherResponseDto {
    private Long id;
    private String firstName;
    private String lastName;
    private Long departmentId;
    private List<Long> subjectIds;
}
