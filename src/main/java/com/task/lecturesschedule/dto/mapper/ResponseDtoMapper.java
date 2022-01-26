package com.task.lecturesschedule.dto.mapper;

public interface ResponseDtoMapper<D, T> {
    D mapToDto(T t);
}
