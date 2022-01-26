package com.task.lecturesschedule.service.impl;

import java.util.List;
import com.task.lecturesschedule.model.LectureHall;
import com.task.lecturesschedule.repository.LectureHallRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class LectureHallServiceImplTest {
    @InjectMocks
    private LectureHallServiceImpl lectureHallService;
    @Mock
    private LectureHallRepository departmentRepository;
    private LectureHall hall306;
    private LectureHall hall712;
    private Long hall306Id;
    private Long hall712Id;


    @BeforeEach
    void setUp() {
        hall306 = new LectureHall();
        hall306.setName("306");
        hall306.setCapacity(60);
        hall712 = new LectureHall();
        hall712.setName("712");
        hall712.setCapacity(70);
        hall306Id = 1L;
        hall712Id = 2L;
    }

    @Test
    void add_ok() {
        Mockito.when(departmentRepository.save(hall306)).thenReturn(hall306);
        LectureHall actual = lectureHallService.add(hall306);
        Assertions.assertEquals(actual, hall306);
    }

    @Test
    void get_ok() {
        hall306.setId(hall306Id);
        Mockito.when(departmentRepository.getById(hall306Id)).thenReturn(hall306);
        LectureHall actual = lectureHallService.get(hall306Id);
        Assertions.assertEquals(actual, hall306);
    }

    @Test
    void getAll_ok() {
        hall306.setId(hall306Id);
        hall712.setId(hall712Id);
        Mockito.when(departmentRepository.findAll()).thenReturn(List.of(hall306, hall712));
        List<LectureHall> actual = lectureHallService.getAll();
        Assertions.assertEquals(actual, List.of(hall306, hall712));
    }

    @Test
    void update_ok() {
        hall306.setId(hall306Id);
        hall306.setCapacity(99);
        Mockito.when(departmentRepository.save(hall306)).thenReturn(hall306);
        LectureHall actual = lectureHallService.update(hall306);
        Assertions.assertEquals(actual, hall306);
    }
}