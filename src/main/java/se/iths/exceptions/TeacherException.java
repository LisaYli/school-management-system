package se.iths.exceptions;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class TeacherException extends WebApplicationException {

    public TeacherException(String message){
        super(Response.status(Response.Status.BAD_REQUEST)
                .entity(message).type(MediaType.APPLICATION_JSON).build());
    }
}
