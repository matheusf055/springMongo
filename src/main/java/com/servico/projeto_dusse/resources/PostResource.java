package com.servico.projeto_dusse.resources;

import com.servico.projeto_dusse.domain.Post;
import com.servico.projeto_dusse.services.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController // Anotação que indica que esta classe é um controlador REST
@RequestMapping(value="/posts") // Mapeia as requisições HTTP para "/posts"
public class PostResource {

    private final PostService service;

    // Construtor para injetar a dependência do serviço de Post
    public PostResource(PostService service) {
        this.service = service;
    }

    // Mapeia requisições GET para "/posts/{id}"
    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {
        // Chama o serviço para buscar um post pelo ID
        Post obj = service.findById(id);
        // Retorna o objeto Post encontrado com status HTTP 200 (OK)
        return ResponseEntity.ok().body(obj);
    }
}
