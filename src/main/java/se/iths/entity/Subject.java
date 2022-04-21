package se.iths.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "subject")
@Entity
public class Subject  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToMany
    @JsonBackReference
    private List<Student> students = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Teacher> teachers;

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addTeacher(Teacher teacher) {
        if(teachers == null){
            teachers = new ArrayList<>();
        }
        teachers.add(teacher);
    }
}
