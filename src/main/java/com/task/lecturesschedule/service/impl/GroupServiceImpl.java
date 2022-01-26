package com.task.lecturesschedule.service.impl;

import com.task.lecturesschedule.model.Group;
import com.task.lecturesschedule.repository.GroupRepository;
import com.task.lecturesschedule.service.GroupService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class GroupServiceImpl implements GroupService {
    private final GroupRepository groupRepository;

    public GroupServiceImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public Group add(Group group) {
        return groupRepository.save(group);
    }

    @Override
    public Group get(Long id) {
        return groupRepository.getById(id);
    }

    @Override
    public List<Group> getAll() {
        return groupRepository.findAll();
    }

    @Override
    public Group update(Group group) {
        return groupRepository.save(group);
    }

    @Override
    public void delete(Long id) {
        groupRepository.delete(get(id));
    }
}
