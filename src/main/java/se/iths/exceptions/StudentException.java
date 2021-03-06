package se.iths.exceptions;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class StudentException extends WebApplicationException {

    public StudentException(String message){
        super(Response.status(Response.Status.BAD_REQUEST)
                .entity(message).type(MediaType.APPLICATION_JSON).build());
    }

}
