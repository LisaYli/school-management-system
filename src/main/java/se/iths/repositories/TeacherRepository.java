package se.iths.repositories;

import se.iths.entity.Teacher;

import java.util.List;

public interface TeacherRepository {
    List<Teacher> getAllTeachers();

    Teacher findTeacherById(Long id);

    void createTeacher(Teacher teacher);

    void deleteTeacher(Long id);
}
