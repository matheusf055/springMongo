package com.servico.projeto_dusse.services;

import com.servico.projeto_dusse.domain.User;
import com.servico.projeto_dusse.dto.UserDTO;
import com.servico.projeto_dusse.repository.UserRepository;
import com.servico.projeto_dusse.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    // Método para retornar todos os usuários
    public List<User> findAll(){
        return repo.findAll();
    }

    // Método para buscar um usuário por ID
    public User findById(String id) {
        Optional<User> user = repo.findById(id);

        // Verifica se o usuário foi encontrado
        if (user.isEmpty()) {
            // Lança uma exceção ObjectNotFoundException se o usuário não for encontrado
            throw new ObjectNotFoundException("Objeto não encontrado");
        }

        // Retorna o usuário encontrado
        return user.get();
    }

    // Método para inserir um novo usuário
    public User insert(User obj){
        return repo.insert(obj);
    }

    // Método para deletar um usuário pelo ID
    public void delete(String id){
        // Verifica se o usuário existe antes de deletá-lo
        findById(id);
        repo.deleteById(id);
    }

    // Método para atualizar um usuário
    public User update(User obj){
        // Busca o usuário a ser atualizado pelo ID
        User newObj = findById(obj.getId());
        // Atualiza os dados do usuário com base nos dados do objeto passado como argumento
        updateData(newObj, obj);
        // Salva e retorna o usuário atualizado
        return repo.save(newObj);
    }

    // Método auxiliar para atualizar os dados do usuário
    private void updateData(User newObj, User obj){
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }

    // Método para converter um objeto UserDTO em um objeto User
    public User fromDTO(UserDTO objDto){
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }
}
