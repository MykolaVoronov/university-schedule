package com.task.lecturesschedule.service.impl;

import java.util.List;
import com.task.lecturesschedule.model.Department;
import com.task.lecturesschedule.model.Group;
import com.task.lecturesschedule.repository.GroupRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GroupServiceImplTest {
    @InjectMocks
    private GroupServiceImpl groupService;
    @Mock
    private GroupRepository groupRepository;
    private Group at171;
    private Group ai134;
    private Long at171Id;
    private Long ai134Id;


    @BeforeEach
    void setUp() {
        at171 = new Group();
        at171.setName("AT171");
        at171.setSpecialization("Automation and computer-integrated technologies");
        Department kiss = new Department();
        kiss.setId(1L);
        kiss.setName("KISS");
        kiss.setFaculty("ICS");
        at171.setDepartment(kiss);
        ai134 = new Group();
        ai134.setName("AI134");
        ai134.setSpecialization("Computer science");
        ai134.setDepartment(kiss);
        at171Id = 1L;
        ai134Id = 2L;
    }

    @Test
    void add_ok() {
        Mockito.when(groupRepository.save(at171)).thenReturn(at171);
        Group actual = groupService.add(at171);
        Assertions.assertEquals(actual, at171);
    }

    @Test
    void get_ok() {
        at171.setId(at171Id);
        Mockito.when(groupRepository.getById(at171Id)).thenReturn(at171);
        Group actual = groupService.get(at171Id);
        Assertions.assertEquals(actual, at171);
    }

    @Test
    void getAll_ok() {
        at171.setId(at171Id);
        ai134.setId(ai134Id);
        Mockito.when(groupRepository.findAll()).thenReturn(List.of(at171, ai134));
        List<Group> actual = groupService.getAll();
        Assertions.assertEquals(actual, List.of(at171, ai134));
    }

    @Test
    void update_ok() {
        at171.setId(at171Id);
        at171.setSpecialization("KEK");
        Mockito.when(groupRepository.save(at171)).thenReturn(at171);
        Group actual = groupService.update(at171);
        Assertions.assertEquals(actual, at171);
    }
}