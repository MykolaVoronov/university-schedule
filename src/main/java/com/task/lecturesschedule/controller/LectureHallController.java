package com.task.lecturesschedule.controller;

import com.task.lecturesschedule.dto.mapper.LectureHallMapper;
import com.task.lecturesschedule.dto.request.LectureHallRequestDto;
import com.task.lecturesschedule.dto.response.LectureHallResponseDto;
import com.task.lecturesschedule.model.LectureHall;
import com.task.lecturesschedule.service.LectureHallService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lecture-halls")
@AllArgsConstructor
public class LectureHallController {
    private final LectureHallService lectureHallService;
    private final LectureHallMapper lectureHallMapper;

    @PostMapping
    public LectureHallResponseDto add(@RequestBody LectureHallRequestDto dto) {
        LectureHall lectureHall = lectureHallService.add(lectureHallMapper.mapToModel(dto));
        return lectureHallMapper.mapToDto(lectureHall);
    }

    @GetMapping("/get/{id}")
    public LectureHallResponseDto get(@PathVariable Long id) {
        return lectureHallMapper.mapToDto(lectureHallService.get(id));
    }

    @GetMapping
    public List<LectureHallResponseDto> getAll() {
        return lectureHallService.getAll().stream()
                .map(lectureHallMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/update/{id}")
    public LectureHallResponseDto update(@PathVariable Long id,
                                         @RequestBody LectureHallRequestDto dto) {
        LectureHall lectureHall = lectureHallService.get(id);
        lectureHall.setName(dto.getName());
        lectureHall.setCapacity(dto.getCapacity());
        return lectureHallMapper.mapToDto(lectureHallService.update(lectureHall));
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        lectureHallService.delete(id);
    }
}
