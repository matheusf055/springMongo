package com.servico.projeto_dusse.services.exception;

// Classe que representa uma exceção quando um objeto não é encontrado
public class ObjectNotFoundException extends RuntimeException{

    // Construtor que recebe uma mensagem de erro e repassa para o construtor da classe pai
    public ObjectNotFoundException(String msg){
        super(msg);
    }
}
