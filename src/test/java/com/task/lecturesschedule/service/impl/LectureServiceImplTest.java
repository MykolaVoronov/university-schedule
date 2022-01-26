package com.task.lecturesschedule.service.impl;

import java.time.LocalDate;
import java.util.List;
import com.task.lecturesschedule.model.Department;
import com.task.lecturesschedule.model.Group;
import com.task.lecturesschedule.model.Lecture;
import com.task.lecturesschedule.model.LectureHall;
import com.task.lecturesschedule.model.Student;
import com.task.lecturesschedule.model.Subject;
import com.task.lecturesschedule.model.Teacher;
import com.task.lecturesschedule.repository.LectureRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class LectureServiceImplTest {
    @InjectMocks
    private LectureServiceImpl lectureService;
    @Mock
    private LectureRepository lectureRepository;
    @Mock
    private StudentServiceImpl studentService;
    private Lecture lectureA;
    private Lecture lectureB;
    private Group at171;
    private Long lectureAId;
    private Long lectureBId;


    @BeforeEach
    void setUp() {
        Department kiss = new Department();
        kiss.setId(1L);
        kiss.setName("KISS");
        kiss.setFaculty("ICS");
        at171 = new Group();
        at171.setId(1L);
        at171.setName("AT171");
        at171.setSpecialization("Automation and computer-integrated technologies");
        at171.setDepartment(kiss);
        Subject programming = new Subject();
        programming.setId(1L);
        programming.setName("Programming");
        Teacher berkov = new Teacher();
        berkov.setFirstName("Uriy");
        berkov.setLastName("Berkov");
        berkov.setDepartment(kiss);
        berkov.setSubjects(List.of(programming));
        LectureHall lectureHallA = new LectureHall();
        lectureHallA.setId(1L);
        lectureHallA.setName("303");
        lectureHallA.setCapacity(35);
        LectureHall lectureHallB = new LectureHall();
        lectureHallB.setId(2L);
        lectureHallB.setName("370");
        lectureHallB.setCapacity(65);
        lectureA = new Lecture();
        lectureA.setLectureHall(lectureHallA);
        lectureA.setSubject(programming);
        lectureA.setGroup(at171);
        lectureA.setTeacher(berkov);
        lectureA.setStartDate(LocalDate.of(2022, 1, 26));
        lectureB = new Lecture();
        lectureB.setLectureHall(lectureHallB);
        lectureA.setSubject(programming);
        lectureA.setGroup(at171);
        lectureA.setTeacher(berkov);
        lectureA.setStartDate(LocalDate.of(2022, 1, 27));
        lectureAId = 1L;
        lectureBId = 2L;
    }

    @Test
    void add_ok() {
        Mockito.when(lectureRepository.save(lectureA)).thenReturn(lectureA);
        Lecture actual = lectureService.add(lectureA);
        Assertions.assertEquals(actual, lectureA);
    }

    @Test
    void get_ok() {
        lectureA.setId(lectureAId);
        Mockito.when(lectureRepository.getById(lectureAId)).thenReturn(lectureA);
        Lecture actual = lectureService.get(lectureAId);
        Assertions.assertEquals(actual, lectureA);
    }

    @Test
    void getAll_ok() {
        lectureA.setId(lectureAId);
        lectureB.setId(lectureBId);
        Mockito.when(lectureRepository.findAll()).thenReturn(List.of(lectureA, lectureB));
        List<Lecture> actual = lectureService.getAll();
        Assertions.assertEquals(actual, List.of(lectureA, lectureB));
    }

    @Test
    void update_ok() {
        lectureA.setId(lectureAId);
        lectureA.setStartDate(LocalDate.of(2022, 1, 28));
        Mockito.when(lectureRepository.save(lectureA)).thenReturn(lectureA);
        Lecture actual = lectureService.update(lectureA);
        Assertions.assertEquals(actual, lectureA);
    }

    @Test
    void findAllAvailableForStudent_ok() {
        Student student = new Student();
        student.setId(1L);
        student.setFirstName("Ivan");
        student.setLastName("Vasiliev");
        student.setGroup(at171);
        LocalDate lectureDate = LocalDate.of(2022, 1, 26);
        Mockito.when(studentService.get(student.getId())).thenReturn(student);
        Mockito.when(lectureRepository.findAvailableForGroup(student.getId(), lectureDate)).thenReturn(List.of(lectureA));
        List<Lecture> actual = lectureService.findAllAvailableForStudent(student.getId(), lectureDate);
        Assertions.assertEquals(List.of(lectureA), actual);
    }
}