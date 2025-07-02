package com.prefeitura.relatos.services;


import com.prefeitura.relatos.dto.UserRequestDTO;
import com.prefeitura.relatos.dto.UserResponseDTO;
import com.prefeitura.relatos.model.User;
import com.prefeitura.relatos.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserResponseDTO cadastrarUsuario(UserRequestDTO dto){
        Optional<User> usuarioExistente = userRepository.findByEmail(dto.email());

        if(usuarioExistente.isPresent()){
            throw new RuntimeException("Email já cadastrado");
        }
        User novoUsuario = User.builder()
                .nome(dto.nome())
                .email(dto.email())
                .senha(dto.senha())
                .role(dto.role())
                .build();

        User usuarioSalvo = userRepository.save(novoUsuario);

        return new UserResponseDTO(
                usuarioSalvo.getId(),
                usuarioSalvo.getNome(),
                usuarioSalvo.getEmail(),
                usuarioSalvo.getRole()
        );
    }

}
