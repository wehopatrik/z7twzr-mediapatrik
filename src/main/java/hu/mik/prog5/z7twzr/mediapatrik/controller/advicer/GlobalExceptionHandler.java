package hu.mik.prog5.z7twzr.mediapatrik.controller.advicer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception e) {
        log.error("ERROR HAPPENED: " + e);

        return new ModelAndView("error/error");
    }

}
