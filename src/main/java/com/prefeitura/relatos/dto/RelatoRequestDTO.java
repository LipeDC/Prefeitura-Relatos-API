package com.prefeitura.relatos.dto;

import com.prefeitura.relatos.enums.Categoria;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RelatoRequestDTO(
    @NotBlank String titulo,
    @NotBlank String descricao,
    @NotNull Categoria categoria,
    @NotNull Long usuarioId
){}
