package org.koreait.global.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Map;

@Getter @Setter
public class CommonException extends RuntimeException {
    private final HttpStatus status;
    private boolean errorCode;
    private Map<String, List<String>> errorMessage;

    public CommonException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public CommonException(Map<String, List<String>> errorMessage, HttpStatus status){
        this.status = status;
        this.errorMessage = errorMessage;
    }
}
