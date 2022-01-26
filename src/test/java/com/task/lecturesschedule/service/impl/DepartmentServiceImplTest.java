package com.task.lecturesschedule.service.impl;

import java.util.List;
import com.task.lecturesschedule.model.Department;
import com.task.lecturesschedule.repository.DepartmentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplTest {
    @InjectMocks
    private DepartmentServiceImpl departmentService;
    @Mock
    private DepartmentRepository departmentRepository;
    private Department cisn;
    private Department epem;
    private Long cisnId;
    private Long epemId;


    @BeforeEach
    void setUp() {
        cisn = new Department();
        cisn.setName("CISN");
        cisn.setFaculty("ICS");
        epem = new Department();
        epem.setName("EPEM");
        epem.setFaculty("IEEM");
        cisnId = 1L;
        epemId = 2L;
    }

    @Test
    void add_ok() {
        Mockito.when(departmentRepository.save(cisn)).thenReturn(cisn);
        Department actual = departmentService.add(cisn);
        Assertions.assertEquals(actual, cisn);
    }

    @Test
    void get_ok() {
        cisn.setId(cisnId);
        Mockito.when(departmentRepository.getById(cisnId)).thenReturn(cisn);
        Department actual = departmentService.get(cisnId);
        Assertions.assertEquals(actual, cisn);
    }

    @Test
    void getAll_ok() {
        cisn.setId(cisnId);
        epem.setId(epemId);
        Mockito.when(departmentRepository.findAll()).thenReturn(List.of(cisn, epem));
        List<Department> actual = departmentService.getAll();
        Assertions.assertEquals(actual, List.of(cisn, epem));
    }

    @Test
    void update_ok() {
        cisn.setId(cisnId);
        cisn.setFaculty("IEEM");
        Mockito.when(departmentRepository.save(cisn)).thenReturn(cisn);
        Department actual = departmentService.update(cisn);
        Assertions.assertEquals(actual, cisn);
    }
}