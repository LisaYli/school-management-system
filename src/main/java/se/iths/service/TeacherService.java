package se.iths.service;

import se.iths.entity.Teacher;
import se.iths.repositories.TeacherRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class TeacherService implements TeacherRepository {

    @PersistenceContext(unitName = "MyPU")
    EntityManager entityManager;

    @Override
    public List<Teacher> getAllTeachers() {
        return entityManager.createQuery("SELECT t FROM Teacher t", Teacher.class).getResultList();
    }

    @Override
    public Teacher findTeacherById(Long id) {
        return entityManager.find(Teacher.class, id);
    }

    @Override
    public void createTeacher(Teacher teacher) {
        entityManager.persist(teacher);
    }

    @Override
    public void deleteTeacher(Long id) {
        Teacher findTeacher = entityManager.find(Teacher.class, id);
        entityManager.remove(findTeacher);
        System.out.println("Teacher with " + id + " is removed");
    }
}
