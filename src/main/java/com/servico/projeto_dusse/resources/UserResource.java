package com.servico.projeto_dusse.resources;

import com.servico.projeto_dusse.domain.Post;
import com.servico.projeto_dusse.domain.User;
import com.servico.projeto_dusse.dto.UserDTO;
import com.servico.projeto_dusse.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController // Indica que esta classe é um controlador REST
@RequestMapping(value="/users") // Mapeia as requisições HTTP para "/users"
public class UserResource {

    private final UserService service;

    // Construtor para injetar a dependência do serviço de User
    public UserResource(UserService service) {
        this.service = service;
    }

    // Mapeia requisições GET para "/users"
    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> list = service.findAll(); // Busca todos os usuários
        List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList()); // Converte a lista de User para UserDTO
        return ResponseEntity.ok().body(listDto); // Retorna a lista de UserDTO com status HTTP 200 (OK)
    }

    // Mapeia requisições GET para "/users/{id}"
    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {
        User obj = service.findById(id); // Busca o usuário pelo ID
        return ResponseEntity.ok().body(new UserDTO(obj)); // Retorna o UserDTO correspondente com status HTTP 200 (OK)
    }

    // Mapeia requisições POST para "/users/{id}"
    @PostMapping(value = "/{id}")
    public ResponseEntity<Void> insert(@RequestBody UserDTO objDto) {
        User obj = service.fromDTO(objDto); // Converte UserDTO para User
        obj = service.insert(obj); // Insere o novo usuário no banco de dados
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri(); // Cria a URI do novo recurso
        return ResponseEntity.created(uri).build(); // Retorna a URI do novo recurso com status HTTP 201 (Created)
    }

    // Mapeia requisições DELETE para "/users/{id}"
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id); // Deleta o usuário pelo ID
        return ResponseEntity.noContent().build(); // Retorna status HTTP 204 (No Content)
    }

    // Mapeia requisições PUT para "/users/{id}"
    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@RequestBody UserDTO objDto, @PathVariable String id) {
        User obj = service.fromDTO(objDto); // Converte UserDTO para User
        obj.setId(id); // Define o ID do usuário a ser atualizado
        service.update(obj); // Atualiza o usuário no banco de dados
        return ResponseEntity.noContent().build(); // Retorna status HTTP 204 (No Content)
    }

    // Mapeia requisições GET para "/users/{id}/posts"
    @GetMapping(value = "/{id}/posts")
    public ResponseEntity<List<Post>> findPosts(@PathVariable String id) {
        User obj = service.findById(id); // Busca o usuário pelo ID
        return ResponseEntity.ok().body(obj.getPosts()); // Retorna a lista de posts do usuário com status HTTP 200 (OK)
    }
}
