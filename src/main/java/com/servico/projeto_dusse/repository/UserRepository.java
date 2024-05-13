package com.servico.projeto_dusse.repository;

import com.servico.projeto_dusse.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository <User, String> { // Criando um repositorio no mongo, passando o User e o tipo do ID

}
