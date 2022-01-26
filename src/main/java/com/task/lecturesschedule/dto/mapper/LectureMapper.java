package com.task.lecturesschedule.dto.mapper;

import com.task.lecturesschedule.dto.request.LectureRequestDto;
import com.task.lecturesschedule.dto.response.LectureResponseDto;
import com.task.lecturesschedule.model.Lecture;
import com.task.lecturesschedule.service.GroupService;
import com.task.lecturesschedule.service.LectureHallService;
import com.task.lecturesschedule.service.SubjectService;
import com.task.lecturesschedule.service.TeacherService;
import com.task.lecturesschedule.util.DatePatternUtil;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;

@Component
public class LectureMapper implements ResponseDtoMapper<LectureResponseDto, Lecture>,
        RequestDtoMapper<LectureRequestDto, Lecture> {
    private final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern(DatePatternUtil.DATE_PATTERN);
    private final LectureHallService lectureHallService;
    private final GroupService groupService;
    private final SubjectService subjectService;
    private final TeacherService teacherService;

    public LectureMapper(LectureHallService lectureHallService,
                         GroupService groupService,
                         SubjectService subjectService,
                         TeacherService teacherService) {
        this.lectureHallService = lectureHallService;
        this.groupService = groupService;
        this.subjectService = subjectService;
        this.teacherService = teacherService;
    }

    @Override
    public Lecture mapToModel(LectureRequestDto dto) {
        Lecture lecture = new Lecture();
        lecture.setLectureHall(lectureHallService.get(dto.getLectureHallId()));
        lecture.setGroup(groupService.get(dto.getGroupId()));
        lecture.setSubject(subjectService.get(dto.getSubjectId()));
        lecture.setTeacher(teacherService.get(dto.getTeacherId()));
        lecture.setStartDate(LocalDate.parse(dto.getStartDate(), formatter));
        return lecture;
    }

    @Override
    public LectureResponseDto mapToDto(Lecture lecture) {
        LectureResponseDto dto = new LectureResponseDto();
        dto.setId(lecture.getId());
        dto.setLectureHallId(lecture.getLectureHall().getId());
        dto.setGroupId(lecture.getGroup().getId());
        dto.setSubjectId(lecture.getSubject().getId());
        dto.setTeacherId(lecture.getTeacher().getId());
        dto.setStartDate(lecture.getStartDate().format(formatter));
        return dto;
    }
}
