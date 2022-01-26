package com.task.lecturesschedule.dto.request;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TeacherRequestDto {
    private String firstName;
    private String lastName;
    private Long departmentId;
    private List<Long> subjectIds;
}
