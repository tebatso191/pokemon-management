package za.co.standardbank.card.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public String handleException(Exception ex) {
        log.error("An Error Occurred: {}", ex.getMessage());
        return "An Error Occurred: " + ex.getMessage();
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String handleIllegalArgumentException(IllegalArgumentException ex) {
        log.error("Bad Request: {}", ex.getMessage());
        return "Bad Request: " + ex.getMessage();
    }

    @ExceptionHandler(HttpClientErrorException.NotFound.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String handleIllegalNotFoundException(HttpClientErrorException.NotFound ex) {
        log.error("Bad Request: {}", ex.getMessage());
        return "Bad Request: " + ex.getMessage();
    }
}