package com.servico.projeto_dusse.dto;

import com.servico.projeto_dusse.domain.User;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class AuthorDTO implements Serializable {

    //Campos relacionado ao ID e nome do Autor
    private String id;
    private String name;

    //Construtores
    public AuthorDTO() {
    }

    //Construtor que inicializa o AuthorDTO como um objeto de user
    public AuthorDTO(User obj) {
        id = obj.getId(); //Define o ID a partir do user
        name = obj.getName(); //Define o nome a partir do user
    }
}
