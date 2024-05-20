package com.servico.projeto_dusse.config;

import com.servico.projeto_dusse.domain.Post;
import com.servico.projeto_dusse.domain.User;
import com.servico.projeto_dusse.dto.AuthorDTO;
import com.servico.projeto_dusse.dto.CommentDTO;
import com.servico.projeto_dusse.repository.PostRepository;
import com.servico.projeto_dusse.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner{

    @Autowired
    private UserRepository userRepository; // Chama o UserRepository

    @Autowired
    private PostRepository postRepository; // Chama o PostRepostory

    @Override
    public void run(String... args) throws Exception {

        //Configuração do formato da data
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        //Limpa os repositorios
        userRepository.deleteAll();
        postRepository.deleteAll();

        //Cria usuarios
        User farlley = new User(null, "Farlley", "farlley@gmail.com");
        User matheus = new User(null, "Matheus", "matheus@gmail.com");
        User patrick = new User(null, "Patrick", "patrick@gmail.com");
        User raissa = new User(null, "Raissa", "raissa@gmail.com");

        //Salva os usuarios
        userRepository.saveAll(Arrays.asList(farlley, matheus, patrick, raissa));

        //Criação de posts associando a um usuario
        Post post1 = new Post(null, sdf.parse("21/03/2024"), "Partiu viagem", "Vou viajar, abraços!", new AuthorDTO(farlley));
        Post post2 = new Post(null, sdf.parse("23/03/2024"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(farlley));

        //Criação de comentários
        CommentDTO c1 = new CommentDTO("Boa viagem mano!", new AuthorDTO(matheus), sdf.parse("21/03/2024"));
        CommentDTO c2 = new CommentDTO("Aproveita", new AuthorDTO(patrick), sdf.parse("22/03/2024"));
        CommentDTO c3 = new CommentDTO("Tenha um ótimo dia!", new AuthorDTO(matheus), sdf.parse("23/03/2024"));

        //Associa comentários a um post
        post1.getComments().addAll(Arrays.asList(c1, c2));
        post2.getComments().addAll(Arrays.asList(c3));

        //Salva os posts no banco de dados
        postRepository.saveAll(Arrays.asList(post1, post2));

        //Associa os posts ao usuario Farlley
        farlley.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(farlley);
    }
}
