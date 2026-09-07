package com.example.demo.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> tratarErroValidacao(
            MethodArgumentNotValidException exception) {

        Map<String, String> erros = new HashMap<>();

        exception.getBindingResult()
                .getFieldErrors()
                .forEach(erro -> {
                    erros.put(erro.getField(), erro.getDefaultMessage());
                });

        return ResponseEntity.badRequest().body(erros);
    }
    
    @ExceptionHandler(ProdutoNotFoundException.class)
    public ResponseEntity<Map<String, String>> tratarProdutoNaoEncontrado(
            ProdutoNotFoundException exception) {

        Map<String, String> erro = new HashMap<>();

        erro.put("erro", exception.getMessage());

        return ResponseEntity.status(404).body(erro);
    }
}