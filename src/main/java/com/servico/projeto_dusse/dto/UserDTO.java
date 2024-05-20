package com.servico.projeto_dusse.dto;

import com.servico.projeto_dusse.domain.User;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class UserDTO implements Serializable {

    // Identificador único do usuário
    private String id;

    // Nome do usuário
    private String name;

    // Email do usuário
    private String email;

    // Construtor padrão
    public UserDTO() {
    }

    // Construtor que inicializa o UserDTO com base em um objeto User
    public UserDTO(User obj) {
        id = obj.getId();  // Atribui o ID do objeto User ao campo id
        name = obj.getName();  // Atribui o nome do objeto User ao campo name
        email = obj.getEmail();  // Atribui o email do objeto User ao campo email
    }
}
