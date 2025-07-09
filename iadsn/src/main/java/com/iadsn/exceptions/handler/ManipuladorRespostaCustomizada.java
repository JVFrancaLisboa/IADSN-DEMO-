package com.iadsn.exceptions.handler;

import com.iadsn.exceptions.ExceptionResponse;
import com.iadsn.exceptions.MembroComVinculoException;
import org.hibernate.TransientObjectException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class ManipuladorRespostaCustomizada extends ResponseEntityExceptionHandler {
//
//    @ExceptionHandler(Exception.class)
//    public final ResponseEntity<ExceptionResponse> allExceptions(Exception ex, WebRequest request){
//
//        ExceptionResponse resposta = new ExceptionResponse(
//                new Date(),
//                ex.getMessage(),
//                request.getDescription(false)
//        );
//
//        return new ResponseEntity<>(resposta, HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//
//    @ExceptionHandler(MembroComVinculoException.class)
//    public ModelAndView membroComVinculo(MembroComVinculoException ex){
//        ModelAndView mv = new ModelAndView("erro-exclusao");
//        mv.addObject("mensagemErro", ex.getMessage());
//        return mv;
//    }
}
