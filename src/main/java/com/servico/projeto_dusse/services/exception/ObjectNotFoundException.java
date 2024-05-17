package com.servico.projeto_dusse.services.exception;

public class ObjectNotFoundException extends RuntimeException{

    public ObjectNotFoundException(String msg){
        super(msg);
    }
}
