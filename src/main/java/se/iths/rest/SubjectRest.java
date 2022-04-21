package se.iths.rest;

import se.iths.entity.Student;
import se.iths.entity.Subject;
import se.iths.entity.Teacher;
import se.iths.exceptions.SchoolAppException;
import se.iths.service.StudentService;
import se.iths.service.SubjectService;
import se.iths.service.TeacherService;
import se.iths.validations.ApplicationValidation;
import se.iths.validations.StudentValidation;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("subjects")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SubjectRest {

    @Inject
    SubjectService subjectService;

    @Inject
    StudentService studentService;

    @Inject
    TeacherService teacherService;

    @Path("new")
    @POST
    public Response createSubject(Subject subject) {
        var subjects = subjectService.getAllSubjects();
        subjectService.createSubject(subject);
        return Response.ok(subject).build();
    }


    @Path("getall")
    @GET
    public Response getSubjects() {
        List<Subject> subjects = subjectService.getAllSubjects();
        return Response.ok(subjects).build();
    }


    @Path("findbyid/{id}")
    @GET
    public Response findSubjectById(@PathParam("id") Long id) {
        Subject subjectToFind = subjectService.findSubjectById(id);

        return Response.ok(subjectToFind).build();
    }


    @Path("{id}")
    @DELETE
    public Response deleteSubject(@PathParam("id") Long id) {
        subjectService.deleteSubject(id);
        return Response.ok().build();
    }

    @Path("{subjectId}/{studentId}")
    @PATCH
    public Response addStudent(@PathParam("subjectId") Long subjectId, @PathParam("studentId") Long studentId) {
        Student studentToFind = studentService.findStudentById(studentId);

        StudentValidation.checkIfStudentExist(studentToFind);

        subjectService.addStudent(studentToFind, subjectId);

        return Response.ok().build();
    }

    @Path("{subjectId}/t/{teacherId}")
    @PATCH
    public Response addTeacher(@PathParam("subjectId") Long subjectId, @PathParam("teacherId") Long teacherId) {
        Teacher teacherToFind = teacherService.findTeacherById(teacherId);
       ApplicationValidation.checkIfTeacherExist(teacherToFind);
        subjectService.addTeacher(teacherToFind, subjectId);

        return Response.ok().build();
    }


    }

