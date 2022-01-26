package com.task.lecturesschedule.controller;

import com.task.lecturesschedule.dto.mapper.LectureMapper;
import com.task.lecturesschedule.dto.request.LectureRequestDto;
import com.task.lecturesschedule.dto.response.LectureResponseDto;
import com.task.lecturesschedule.model.Lecture;
import com.task.lecturesschedule.service.GroupService;
import com.task.lecturesschedule.service.LectureHallService;
import com.task.lecturesschedule.service.LectureService;
import com.task.lecturesschedule.service.SubjectService;
import com.task.lecturesschedule.service.TeacherService;
import com.task.lecturesschedule.util.DatePatternUtil;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lectures")
@AllArgsConstructor
public class LectureController {
    private static final String DATE_PATTERN = DatePatternUtil.DATE_PATTERN;
    private final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern(DATE_PATTERN);
    private final LectureService lectureService;
    private final LectureMapper lectureMapper;
    private final TeacherService teacherService;
    private final LectureHallService lectureHallService;
    private final GroupService groupService;
    private final SubjectService subjectService;

    @PostMapping
    public LectureResponseDto add(@RequestBody LectureRequestDto dto) {
        Lecture lecture = lectureService.add(lectureMapper.mapToModel(dto));
        return lectureMapper.mapToDto(lecture);
    }

    @GetMapping("/get/{id}")
    public LectureResponseDto get(@PathVariable Long id) {
        return lectureMapper.mapToDto(lectureService.get(id));
    }

    @GetMapping
    public List<LectureResponseDto> getAll() {
        return lectureService.getAll().stream()
                .map(lectureMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/get-available")
    public List<LectureResponseDto> getAllLecturesByStudentIdAndDate(@RequestParam Long id,
                                                                     @RequestParam
                                                                     @DateTimeFormat(pattern =
                                                                             DATE_PATTERN)
                                                                             LocalDate date) {
        return lectureService.findAllAvailableForStudent(id, date).stream()
                .map(lectureMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/update/{id}")
    public LectureResponseDto update(@PathVariable Long id, @RequestBody LectureRequestDto dto) {
        Lecture lecture = lectureService.get(id);
        lecture.setTeacher(teacherService.get(dto.getTeacherId()));
        lecture.setLectureHall(lectureHallService.get(dto.getLectureHallId()));
        lecture.setGroup(groupService.get(dto.getGroupId()));
        lecture.setSubject(subjectService.get(dto.getSubjectId()));
        lecture.setStartDate(LocalDate.parse(dto.getStartDate(), formatter));
        return lectureMapper.mapToDto(lectureService.update(lecture));
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        lectureService.delete(id);
    }
}
