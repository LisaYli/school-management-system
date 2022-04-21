package se.iths.repositories;

import se.iths.entity.Student;

import java.util.List;

public interface StudentRepository{

    List<Student> getAllStudents();

    Student findStudentById(Long id);

    void createStudent(Student student);

    void deleteStudent(Long id);


}
