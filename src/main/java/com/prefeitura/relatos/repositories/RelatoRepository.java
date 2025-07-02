package com.prefeitura.relatos.repositories;

import com.prefeitura.relatos.model.Relato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RelatoRepository extends JpaRepository<Relato,Long> {

}
