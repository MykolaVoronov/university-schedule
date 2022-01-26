package com.task.lecturesschedule.service.impl;

import java.util.List;
import com.task.lecturesschedule.model.Subject;
import com.task.lecturesschedule.repository.SubjectRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SubjectServiceImplTest {
    @InjectMocks
    private SubjectServiceImpl subjectService;
    @Mock
    private SubjectRepository subjectRepository;
    private Subject math;
    private Subject physics;
    private Long mathId;
    private Long physicsId;


    @BeforeEach
    void setUp() {
        math = new Subject();
        math.setName("Math");
        physics = new Subject();
        physics.setName("Physics");
        mathId = 1L;
        physicsId = 2L;
    }

    @Test
    void add_ok() {
        Mockito.when(subjectRepository.save(math)).thenReturn(math);
        Subject actual = subjectService.add(math);
        Assertions.assertEquals(actual, math);
    }

    @Test
    void get_ok() {
        math.setId(mathId);
        Mockito.when(subjectRepository.getById(mathId)).thenReturn(math);
        Subject actual = subjectService.get(mathId);
        Assertions.assertEquals(actual, math);
    }

    @Test
    void getAll_ok() {
        math.setId(mathId);
        physics.setId(physicsId);
        Mockito.when(subjectRepository.findAll()).thenReturn(List.of(math, physics));
        List<Subject> actual = subjectService.getAll();
        Assertions.assertEquals(actual, List.of(math, physics));
    }

    @Test
    void update_ok() {
        math.setId(mathId);
        math.setName("Astronomy");
        Mockito.when(subjectRepository.save(math)).thenReturn(math);
        Subject actual = subjectService.update(math);
        Assertions.assertEquals(actual, math);
    }
}