package com.prefeitura.relatos.controllers;

import com.prefeitura.relatos.dto.RelatoRequestDTO;
import com.prefeitura.relatos.dto.RelatoResponseDTO;
import com.prefeitura.relatos.services.RelatoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/relatos")
public class RelatoController {
    @Autowired
    private RelatoService relatoService;

    @PostMapping
    public ResponseEntity<RelatoResponseDTO> criarRelato(@RequestBody @Valid RelatoRequestDTO dto){
        RelatoResponseDTO relatoCriado = relatoService.criarRelato(dto);
        return ResponseEntity.ok(relatoCriado);
    }

    @GetMapping
    public ResponseEntity<List<RelatoResponseDTO>> listarRelatos() {
        List<RelatoResponseDTO> relatos = relatoService.listarRelatos();
        return ResponseEntity.ok(relatos);
    }
    @PutMapping("/{id}")
    public ResponseEntity<RelatoResponseDTO> atualizarRelato(@PathVariable Long id, @RequestBody RelatoRequestDTO dto) {
        RelatoResponseDTO atualizado = relatoService.atualizarRelato(id, dto);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarRelato(@PathVariable Long id) {
        relatoService.deletarRelato(id);
        return ResponseEntity.noContent().build();
    }
}
