package se.iths.service;


import se.iths.entity.Student;
import se.iths.entity.Subject;
import se.iths.repositories.StudentRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class StudentService implements StudentRepository {

    @PersistenceContext(unitName = "MyPU")
    EntityManager entityManager;


    @Override
    public List<Student> getAllStudents() {
        return entityManager.createQuery("SELECT s from Student s", Student.class).getResultList();
    }

    @Override
    public Student findStudentById(Long id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public void createStudent(Student student) {
        entityManager.persist(student);
    }


    @Override
    public void deleteStudent(Long id) {
        Student findStudent = entityManager.find(Student.class, id);
        entityManager.remove(findStudent);
        System.out.println("Student with " + id + " is removed");
    }

    public List<Student> findStudentByLastname(String lastname) {
        String query = "SELECT s FROM Student s WHERE s.lastname = :lastname";
        return entityManager.createQuery(query, Student.class).setParameter("lastname", lastname).getResultList();
    }

    public List<Student> findStudentByEmail(String email) {
        String query = "SELECT s FROM Student s WHERE s.email=:email";
        return entityManager.createQuery(query, Student.class).setParameter("email", email).getResultList();
    }


    public Student updateStudentFirstname(Long id, String firstname) {
        Student studentToFind = entityManager.find(Student.class, id);
        studentToFind.setFirstname(firstname);
        return studentToFind;
    }

    public Student updateStudentLastname(Long id, String lastname) {
        Student studentToFind = entityManager.find(Student.class, id);
        studentToFind.setLastname(lastname);
        return studentToFind;
    }


    public Student updateStudentEmail(Long id, String email) {
        Student studentToFind = entityManager.find(Student.class, id);
        studentToFind.setEmail(email);
        return studentToFind;
    }



}


