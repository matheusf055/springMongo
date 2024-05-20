package com.servico.projeto_dusse.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class CommentDTO implements Serializable {

    // Texto do comentário
    private String text;

    // Data do comentário
    private Date date;

    // Autor do comentário representado por AuthorDTO
    private AuthorDTO author;

    // Construtor padrão
    public CommentDTO() {
    }

    // Construtor que inicializa o CommentDTO com texto, autor e data
    // O AuthorDTO é inicializado com um objeto de User
    public CommentDTO(String text, AuthorDTO author, Date date) {
        this.text = text;
        this.author = author;
        this.date = date;
    }
}
