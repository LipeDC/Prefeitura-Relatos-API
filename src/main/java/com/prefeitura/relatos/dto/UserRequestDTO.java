package com.prefeitura.relatos.dto;

import com.prefeitura.relatos.enums.Role;

public record UserRequestDTO(
        String nome,
        String email,
        String senha,
        Role role
) {}
