package se.iths.service;

import se.iths.entity.Student;
import se.iths.entity.Subject;
import se.iths.entity.Teacher;
import se.iths.repositories.SubjectRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class SubjectService implements SubjectRepository {

    @PersistenceContext(unitName = "MyPU")
    EntityManager entityManager;

    @Override
    public List<Subject> getAllSubjects() {
        return entityManager.createQuery("SELECT s FROM Subject s", Subject.class).getResultList();
    }

    @Override
    public Subject findSubjectById(Long id) {
        return entityManager.find(Subject.class, id);
    }

    @Override
    public void createSubject(Subject subject) {
        entityManager.persist(subject);
    }

    @Override
    public void deleteSubject(Long id) {
        Subject findSubject = entityManager.find(Subject.class, id);
        entityManager.remove(findSubject);
        System.out.println("Subject with " + id + " is removed");
    }

    public void addStudent(Student student, Long subjectId) {
        Subject found = entityManager.find(Subject.class, subjectId);
        found.addStudent(student);
        entityManager.merge(found);
    }

    public void addTeacher(Teacher teacherToFind, Long subjectId) {
        Subject found = entityManager.find(Subject.class, subjectId);
        found.setTeacher(teacherToFind);
        teacherToFind.addSubject(found);
        entityManager.merge(found);
    }
}
