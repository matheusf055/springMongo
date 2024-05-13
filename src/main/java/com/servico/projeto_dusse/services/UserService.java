package com.servico.projeto_dusse.services;

import com.servico.projeto_dusse.domain.User;
import com.servico.projeto_dusse.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll(){
        return repo.findAll();
    }
}
