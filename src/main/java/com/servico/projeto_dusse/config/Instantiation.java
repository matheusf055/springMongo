package com.servico.projeto_dusse.config;

import com.servico.projeto_dusse.domain.Post;
import com.servico.projeto_dusse.domain.User;
import com.servico.projeto_dusse.dto.AuthorDTO;
import com.servico.projeto_dusse.dto.CommentDTO;
import com.servico.projeto_dusse.repository.PostRepository;
import com.servico.projeto_dusse.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner{

    private final UserRepository userRepository;

    private final PostRepository postRepository;

    public Instantiation(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null, sdf.parse("21/03/2024"), "Partiu viagem", "Vou viajar, abraços!", new AuthorDTO(maria));
        Post post2 = new Post(null, sdf.parse("23/03/2024"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));

        CommentDTO c1 = new CommentDTO("Boa viagem mano!", new AuthorDTO(alex), sdf.parse("21/03/2024"));
        CommentDTO c2 = new CommentDTO("Aproveita", new AuthorDTO(bob), sdf.parse("22/03/2024"));
        CommentDTO c3 = new CommentDTO("Tenha um ótimo dia!", new AuthorDTO(alex), sdf.parse("23/03/2024"));

        post1.getComments().addAll(Arrays.asList(c1, c2));
        post2.getComments().addAll(Arrays.asList(c3));

        postRepository.saveAll(Arrays.asList(post1, post2));

        maria.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(maria);
    }
}
