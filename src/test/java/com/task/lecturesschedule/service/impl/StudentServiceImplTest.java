package com.task.lecturesschedule.service.impl;

import java.util.List;
import com.task.lecturesschedule.model.Department;
import com.task.lecturesschedule.model.Group;
import com.task.lecturesschedule.model.Student;
import com.task.lecturesschedule.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class StudentServiceImplTest {
    @InjectMocks
    private StudentServiceImpl studentService;
    @Mock
    private StudentRepository studentRepository;
    private Student alice;
    private Student bob;
    private Long aliceId;
    private Long bobId;


    @BeforeEach
    void setUp() {
        Department kiss = new Department();
        kiss.setId(1L);
        kiss.setName("KISS");
        kiss.setFaculty("ICS");
        Group at171 = new Group();
        at171.setId(1L);
        at171.setName("AT171");
        at171.setSpecialization("Automation and computer-integrated technologies");
        at171.setDepartment(kiss);
        alice = new Student();
        alice.setFirstName("Alice");
        alice.setLastName("Omar");
        alice.setGroup(at171);
        bob = new Student();
        bob.setFirstName("Bob");
        bob.setLastName("Jones");
        bob.setGroup(at171);
        aliceId = 1L;
        bobId = 2L;
    }

    @Test
    void add_ok() {
        Mockito.when(studentRepository.save(alice)).thenReturn(alice);
        Student actual = studentService.add(alice);
        Assertions.assertEquals(actual, alice);
    }

    @Test
    void get_ok() {
        alice.setId(aliceId);
        Mockito.when(studentRepository.getById(aliceId)).thenReturn(alice);
        Student actual = studentService.get(aliceId);
        Assertions.assertEquals(actual, alice);
    }

    @Test
    void getAll_ok() {
        alice.setId(aliceId);
        bob.setId(bobId);
        Mockito.when(studentRepository.findAll()).thenReturn(List.of(alice, bob));
        List<Student> actual = studentService.getAll();
        Assertions.assertEquals(actual, List.of(alice, bob));
    }

    @Test
    void update_ok() {
        alice.setId(aliceId);
        alice.setLastName("Crab");
        Mockito.when(studentRepository.save(alice)).thenReturn(alice);
        Student actual = studentService.update(alice);
        Assertions.assertEquals(actual, alice);
    }
}