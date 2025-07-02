package com.prefeitura.relatos.model;

import com.prefeitura.relatos.enums.Categoria;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Table(name = "relatos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Relato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String descricao;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    private LocalDateTime dataCriacao;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private User usuario;
}
