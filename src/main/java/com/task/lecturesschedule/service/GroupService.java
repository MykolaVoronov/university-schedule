package com.task.lecturesschedule.service;

import com.task.lecturesschedule.model.Group;
import java.util.List;

public interface GroupService {
    Group add(Group group);

    Group get(Long id);

    List<Group> getAll();

    Group update(Group group);

    void delete(Long id);
}
