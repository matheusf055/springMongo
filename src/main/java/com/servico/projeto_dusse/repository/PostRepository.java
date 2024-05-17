package com.servico.projeto_dusse.repository;

import com.servico.projeto_dusse.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository <Post, String> {
}
