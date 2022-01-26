package com.task.lecturesschedule.service.impl;

import java.util.List;
import com.task.lecturesschedule.model.Department;
import com.task.lecturesschedule.model.Subject;
import com.task.lecturesschedule.model.Teacher;
import com.task.lecturesschedule.repository.TeacherRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TeacherServiceImplTest {
    @InjectMocks
    private TeacherServiceImpl teacherService;
    @Mock
    private TeacherRepository teacherRepository;
    private Teacher berkov;
    private Teacher fomin;
    private Long berkovId;
    private Long fominId;


    @BeforeEach
    void setUp() {
        Department kiss = new Department();
        kiss.setId(1L);
        kiss.setName("KISS");
        kiss.setFaculty("ICS");
        Subject programming = new Subject();
        programming.setId(1L);
        programming.setName("Programming");
        berkov = new Teacher();
        berkov.setFirstName("Uriy");
        berkov.setLastName("Berkov");
        berkov.setDepartment(kiss);
        berkov.setSubjects(List.of(programming));
        fomin = new Teacher();
        fomin.setFirstName("Alexander");
        fomin.setLastName("Fomin");
        fomin.setDepartment(kiss);
        fomin.setSubjects(List.of(programming));
        berkovId = 1L;
        fominId = 2L;
    }

    @Test
    void add_ok() {
        Mockito.when(teacherRepository.save(berkov)).thenReturn(berkov);
        Teacher actual = teacherService.add(berkov);
        Assertions.assertEquals(actual, berkov);
    }

    @Test
    void get_ok() {
        berkov.setId(berkovId);
        Mockito.when(teacherRepository.getById(berkovId)).thenReturn(berkov);
        Teacher actual = teacherService.get(berkovId);
        Assertions.assertEquals(actual, berkov);
    }

    @Test
    void getAll_ok() {
        berkov.setId(berkovId);
        fomin.setId(fominId);
        Mockito.when(teacherRepository.findAll()).thenReturn(List.of(berkov, fomin));
        List<Teacher> actual = teacherService.getAll();
        Assertions.assertEquals(actual, List.of(berkov, fomin));
    }

    @Test
    void update_ok() {
        berkov.setId(berkovId);
        berkov.setFirstName("Sanya");
        Mockito.when(teacherRepository.save(berkov)).thenReturn(berkov);
        Teacher actual = teacherService.update(berkov);
        Assertions.assertEquals(actual, berkov);
    }
}