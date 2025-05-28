package org.koreait.global.advices;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.koreait.global.exceptions.CommonException;
import org.koreait.global.exceptions.script.AlertException;
import org.koreait.global.libs.Utils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice("org.koreait")
@RequiredArgsConstructor
public class CommonControllerAdvice {

    private final Utils utils;

    @ExceptionHandler(Exception.class)
    public ModelAndView errorHandler(Exception e, HttpServletRequest request){

        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR; //500
        Map<String, String> data = new HashMap<>();

        String message = e.getMessage();
        String tpl = "error/common";

        if(e instanceof CommonException commonException){
            status = commonException.getStatus();
            // 메시지 코드로 메시지를 가져와야 하는 경우
            if(commonException.isErrorCode()){
                message = utils.getMessage(message);
            }

            // 자바스크립트 alert 형태로 출력하는 예외
            if(e instanceof AlertException){
                tpl = "common/_execute_script";
                String script = String.format("alert('%s');", message);

                data.put("script", script);
            }
        }

        data.put("status", status.toString());
        data.put("message", message);
        data.put("path", request.getRequestURI());
        data.put("method", request.getMethod());

        ModelAndView mv = new ModelAndView();
        mv.setStatus(status);
        mv.addAllObjects(data);
        mv.setViewName(tpl);

        e.printStackTrace();

        return mv;
    }
}
