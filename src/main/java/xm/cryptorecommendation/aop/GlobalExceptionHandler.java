package xm.cryptorecommendation.aop;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import xm.cryptorecommendation.domain.ErrorResponse;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {
    private List<String> details=new ArrayList<>();

    @ExceptionHandler(value = EmptyResultDataAccessException.class)
    public final ResponseEntity<ErrorResponse> handleEmptyResultDataAccessException(Exception ex, WebRequest request) {
        return new ResponseEntity<>(generateErrorResponse(ex,"The record you search for, not found"), HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(value = Exception.class)
    public final ResponseEntity<ErrorResponse> handleAllExceptions(Exception ex, WebRequest request) {
        return new ResponseEntity<>(generateErrorResponse(ex,"An unhandled exception occurred, please contact us"), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ErrorResponse generateErrorResponse(Exception ex,String message){
        details.add(ex.getLocalizedMessage());
        return new ErrorResponse(message, details);
    }

}
