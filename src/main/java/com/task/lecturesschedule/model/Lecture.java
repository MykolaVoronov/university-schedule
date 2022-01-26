package com.task.lecturesschedule.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "lectures")
@Setter
@Getter
@ToString
public class Lecture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "lecture_hall_id")
    private LectureHall lectureHall;
    @ManyToOne
    private Group group;
    @ManyToOne
    private Subject subject;
    @ManyToOne
    private Teacher teacher;
    @Column(name = "start_date")
    private LocalDate startDate;
}
