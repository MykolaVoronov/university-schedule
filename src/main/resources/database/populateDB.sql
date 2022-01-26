INSERT INTO departments(faculty, name)
VALUES ('ICS', 'KISS'),
       ('IEEM', 'EPEM'),
       ('ICS', 'IT');
INSERT INTO groups(name, specialization, department_id)
VALUES ('AI123', 'Computer Science', 3),
       ('AT171', 'Automatizing and computer-integrated technologies', 1);
INSERT INTO students (first_name, last_name, group_id)
VALUES ('Vassily', 'Petrov', 1),
       ('Pjotr', 'Vasechkin', 1),
       ('Max', 'Savchenko', 2);
INSERT INTO lecture_halls (name, capacity)
VALUES ('123a', 123),
       ('303f', 25),
       ('707', 50);
INSERT INTO subjects (name)
VALUES ('Math'),
       ('Physics'),
       ('Programming');
INSERT INTO teachers (first_name, last_name, department_id)
VALUES ('Yurii', 'Berkov', 1),
       ('Yurii', 'Maslov', 2);
INSERT INTO teachers_subjects (teacher_id, subject_id)
VALUES (1, 1),
       (1, 3),
       (2, 2);
INSERT INTO lectures (group_id, lecture_hall_id, subject_id, teacher_id, start_date)
VALUES (1, 1, 1, 1, '2022-01-25'),
       (2, 3, 3, 1, '2022-03-12');