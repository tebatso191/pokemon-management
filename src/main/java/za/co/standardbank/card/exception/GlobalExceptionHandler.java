package za.co.standardbank.card.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;
import za.co.standardbank.card.dto.response.CustomErrorDTO;
import za.co.standardbank.card.enums.CommonEnum;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public CustomErrorDTO handleException(Exception e) {
        String message = e.getMessage();
        log.error("An Error Occurred: {}", message);
        return buildCustomErrorDTOResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR, message, false, CommonEnum.EXCEPTION.getValue());
    }

    private CustomErrorDTO buildCustomErrorDTOResponse(int code, HttpStatus httpStatus, String message, boolean isSuccess, String errorType) {
        CustomErrorDTO customErrorDTO = new CustomErrorDTO();
        customErrorDTO.setLevel("");
        customErrorDTO.setStatus(code);
        customErrorDTO.setError(httpStatus.getReasonPhrase());
        customErrorDTO.setMessage(message);
        customErrorDTO.setSuccess(isSuccess);
        customErrorDTO.setType(errorType);

        return customErrorDTO;
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public CustomErrorDTO handleIllegalArgumentException(IllegalArgumentException e) {
        String message = e.getMessage();
        log.error("Bad Request: {}", message);
        return buildCustomErrorDTOResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND, message, false, CommonEnum.EXCEPTION.getValue());
    }

    @ExceptionHandler(HttpClientErrorException.NotFound.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public CustomErrorDTO handleIllegalNotFoundException(HttpClientErrorException.NotFound e) {
        String message = e.getMessage();
        log.error("Bad Request: {}", message);
        return buildCustomErrorDTOResponse(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST, message, false, CommonEnum.EXCEPTION.getValue());
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public CustomErrorDTO handleIllegalUserNOtFoundException(UsernameNotFoundException e) {
        String message = e.getMessage();
        log.error("Bad Username : {}", message);
        return buildCustomErrorDTOResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND, message, false, CommonEnum.EXCEPTION.getValue());
    }
}