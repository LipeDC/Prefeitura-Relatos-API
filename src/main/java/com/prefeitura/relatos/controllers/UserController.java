package com.prefeitura.relatos.controllers;

import com.prefeitura.relatos.dto.UserRequestDTO;
import com.prefeitura.relatos.dto.UserResponseDTO;
import com.prefeitura.relatos.model.User;
import com.prefeitura.relatos.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping
    public ResponseEntity<UserResponseDTO> cadastrarUsuario(@RequestBody UserRequestDTO dto){
        UserResponseDTO usuarioCriado = userService.cadastrarUsuario(dto);
        return ResponseEntity.ok(usuarioCriado);
    }
}
