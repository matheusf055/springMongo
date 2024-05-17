package com.servico.projeto_dusse.services;

import com.servico.projeto_dusse.domain.Post;
import com.servico.projeto_dusse.domain.User;
import com.servico.projeto_dusse.dto.UserDTO;
import com.servico.projeto_dusse.repository.PostRepository;
import com.servico.projeto_dusse.repository.UserRepository;
import com.servico.projeto_dusse.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private final PostRepository repo;

    public PostService(PostRepository repo) {
        this.repo = repo;
    }

    public Post findById(String id) {
        Optional<Post> user = repo.findById(id);
        if (user.isEmpty()) {
            throw new ObjectNotFoundException("Objeto não encontrado");
        }
        return user.get();
    }

}
