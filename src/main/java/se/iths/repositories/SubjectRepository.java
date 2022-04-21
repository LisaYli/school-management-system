package se.iths.repositories;

import se.iths.entity.Student;
import se.iths.entity.Subject;

import java.util.List;

public interface SubjectRepository {
    List<Subject> getAllSubjects();

    Subject findSubjectById(Long id);

    void createSubject(Subject subject);

    void deleteSubject(Long id);

}
