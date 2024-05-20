package com.servico.projeto_dusse.resources.exception;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

// Anotações Lombok para gerar automaticamente os métodos getter e setter
@Getter
@Setter
public class StandardError implements Serializable {

    // Atributo que armazena o timestamp (momento) do erro
    private Long timestamp;

    // Atributo que armazena o status HTTP do erro
    private Integer status;

    // Atributo que armazena a mensagem de erro genérica
    private String error;

    // Atributo que armazena a mensagem detalhada do erro
    private String message;

    // Atributo que armazena o caminho (URI) da requisição que gerou o erro
    private String path;

    // Construtor padrão
    public StandardError() {
    }

    // Construtor que inicializa todos os atributos
    public StandardError(Long timestamp, Integer status, String error, String message, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }
}
