package com.prefeitura.relatos.dto;

import com.prefeitura.relatos.enums.Role;

public record UserResponseDTO(
        Long id,
        String nome,
        String email,
        Role role
) {}
