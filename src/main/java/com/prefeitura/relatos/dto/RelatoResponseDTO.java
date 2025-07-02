package com.prefeitura.relatos.dto;

import com.prefeitura.relatos.enums.Categoria;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record RelatoResponseDTO(
    Long id,
    String titulo,
    String descricao,
    Categoria categoria,
    LocalDateTime dataCriacao,
    String nomeUsuario
    )
{}
