DROP TABLE IF EXISTS teachers_subjects;
DROP TABLE IF EXISTS lectures;
DROP TABLE IF EXISTS subjects;
DROP TABLE IF EXISTS teachers;
DROP TABLE IF EXISTS students;
DROP TABLE IF EXISTS groups;
DROP TABLE IF EXISTS departments;
DROP TABLE IF EXISTS lecture_halls;

CREATE TABLE departments
(
    id bigserial PRIMARY KEY,
    faculty varchar(255) NOT NULL,
    name varchar(255) NOT NULL
    );

CREATE TABLE lecture_halls
(
    id bigserial PRIMARY KEY,
    name varchar(255) NOT NULL,
    capacity integer NOT NULL
    );

CREATE TABLE subjects
(
    id bigserial PRIMARY KEY,
    name varchar(255) NOT NULL
    );

CREATE TABLE groups
(
    id bigserial PRIMARY KEY,
    name varchar(255) NOT NULL,
    specialization varchar(255) NOT NULL,
    department_id bigint,
    CONSTRAINT Foreign_key_department FOREIGN KEY (department_id)
    REFERENCES departments (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    );

CREATE TABLE students
(
    id bigserial PRIMARY KEY,
    first_name varchar(255) NOT NULL,
    last_name varchar(255) NOT NULL,
    group_id bigint,
    CONSTRAINT Foreign_key_group FOREIGN KEY (group_id)
        REFERENCES groups (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE TABLE teachers
(
    id bigserial PRIMARY KEY,
    first_name varchar(255) NOT NULL,
    last_name varchar(255) NOT NULL,
    department_id bigint,
    CONSTRAINT Foreign_key_department FOREIGN KEY (department_id)
        REFERENCES departments (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

CREATE TABLE lectures
(
    id bigserial PRIMARY KEY,
    group_id bigint NOT NULL,
    lecture_hall_id bigint NOT NULL,
    subject_id bigint NOT NULL,
    teacher_id bigint NOT NULL,
    start_date date NOT NULL,
    CONSTRAINT Foreign_key_lecture_hall FOREIGN KEY (lecture_hall_id)
    REFERENCES lecture_halls (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION,
    CONSTRAINT Foreign_key_teacher FOREIGN KEY (teacher_id)
    REFERENCES teachers (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION,
    CONSTRAINT Foreign_key_group FOREIGN KEY (group_id)
    REFERENCES groups (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION,
    CONSTRAINT Foreign_key_subject FOREIGN KEY (subject_id)
    REFERENCES subjects (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    );

CREATE TABLE teachers_subjects
(
    teacher_id bigint NOT NULL,
    subject_id bigint NOT NULL,
    CONSTRAINT Foreign_key_subject FOREIGN KEY (subject_id)
    REFERENCES subjects (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION,
    CONSTRAINT Foreign_key_teacher FOREIGN KEY (teacher_id)
    REFERENCES teachers (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    );