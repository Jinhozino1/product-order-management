package kr.co.ordermanagement.presentation.controller;

import kr.co.ordermanagement.domain.exception.*;
import kr.co.ordermanagement.presentation.dto.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.*;
import java.util.logging.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CanNotCancellableStateException.class)
    public ResponseEntity<ErrorMessageDto> handleCanNotCancellableState(
            CanNotCancellableStateException ex
    ) {
        ErrorMessageDto errorMessageDto = new ErrorMessageDto(ex.getMessage());
        return new ResponseEntity<>(errorMessageDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorMessageDto> handleEntityNotFoundException(
            EntityNotFoundException ex
    ) {
        ErrorMessageDto errorMessageDto = new ErrorMessageDto(ex.getMessage());
        return new ResponseEntity<>(errorMessageDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NotEnoughAmountException.class)
    public ResponseEntity<ErrorMessageDto> handleNotEnoughAmountException(
            NotEnoughAmountException ex
    ) {
        ErrorMessageDto errorMessageDto = new ErrorMessageDto(ex.getMessage());
        return new ResponseEntity<>(errorMessageDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}