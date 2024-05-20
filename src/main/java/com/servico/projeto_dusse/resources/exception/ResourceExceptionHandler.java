package com.servico.projeto_dusse.resources.exception;

import com.servico.projeto_dusse.services.exception.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// Anotação que indica que esta classe tratará exceções globalmente em toda a aplicação
@ControllerAdvice
public class ResourceExceptionHandler {

    // Método que trata a exceção ObjectNotFoundException
    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException ex, HttpServletRequest request) {

        // Define o status HTTP como 404 (NOT_FOUND)
        HttpStatus status = HttpStatus.NOT_FOUND;

        // Cria um objeto StandardError com os detalhes da exceção
        StandardError error = new StandardError(
                System.currentTimeMillis(), // Momento em que a exceção ocorreu
                status.value(), // Código de status HTTP
                "Não encontrado", // Mensagem de erro
                ex.getMessage(), // Mensagem detalhada da exceção
                request.getRequestURI() // URI da requisição que gerou a exceção
        );

        // Retorna uma ResponseEntity com o status e o corpo do erro
        return ResponseEntity.status(status).body(error);
    }
}
