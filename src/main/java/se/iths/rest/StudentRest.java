package se.iths.rest;

import se.iths.entity.Student;
import se.iths.exceptions.StudentNotFoundException;
import se.iths.service.StudentService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Path("students")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StudentRest {

    @Inject
    StudentService studentService;


    @Path("new")
    @POST
    public Response createStudent(Student student) {
        studentService.createStudent(student);
        return Response.ok(student).build();
    }

    @Path("getall")
    @GET
    public Response getStudents() {
        List<Student> students = studentService.getAllStudents();
        return Response.ok(students).build();
    }

    @Path("findbyid/{id}")
    @GET
    public Response findStudentById(@PathParam("id") Long id){
       Student studentToFind = studentService.findStudentById(id);
        if (studentToFind == null){
            throw new StudentNotFoundException("Student with ID: " + id +  " do not exist, please try another one!");
        }
        return Response.ok(studentToFind).build();
    }


    @Path("update")
    @PUT
    public Response updateStudent(Student student) {
        studentService.updateStudent(student);
        return Response.ok(student).build();
    }

    @Path("{id}")
    @DELETE
    public Response deleteStudent(@PathParam("id") Long id) {
        studentService.deleteStudent(id);
        return Response.ok().build();
    }


}
