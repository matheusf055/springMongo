package com.servico.projeto_dusse.services;

import com.servico.projeto_dusse.domain.Post;
import com.servico.projeto_dusse.repository.PostRepository;
import com.servico.projeto_dusse.services.exception.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {

    private final PostRepository repo;

    // Construtor que injeta o repositório de posts
    public PostService(PostRepository repo) {
        this.repo = repo;
    }

    // Método para buscar um post por ID
    public Post findById(String id) {
        // Busca o post no repositório pelo ID
        Optional<Post> post = repo.findById(id);

        // Verifica se o post foi encontrado
        if (post.isEmpty()) {
            // Lança uma exceção ObjectNotFoundException se o post não for encontrado
            throw new ObjectNotFoundException("Objeto não encontrado");
        }

        // Retorna o post encontrado
        return post.get();
    }
}
