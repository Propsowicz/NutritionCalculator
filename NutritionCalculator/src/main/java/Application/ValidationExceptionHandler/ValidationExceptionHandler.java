package Application.ValidationExceptionHandler;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class ValidationExceptionHandler implements ExceptionMapper<ConstraintViolationException> {

    @Override
    public Response toResponse(ConstraintViolationException e){
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(ExceptionMessage(e))
                .type("application/json")
                .build();
    }

    private String ExceptionMessage(ConstraintViolationException e){
        String msg = "{ValidationErrors:[\n";
        for (ConstraintViolation<?> violation : e.getConstraintViolations()){
            msg += "{PropertyPath:" + violation.getPropertyPath() + ",";
            msg += "ExceptionMessage:" + violation.getMessage() + "},\n";
        }
        msg += "]}";
        return msg;
    }
}
