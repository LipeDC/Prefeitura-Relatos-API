package com.prefeitura.relatos.services;

import com.prefeitura.relatos.dto.RelatoRequestDTO;
import com.prefeitura.relatos.dto.RelatoResponseDTO;
import com.prefeitura.relatos.model.Relato;
import com.prefeitura.relatos.model.User;
import com.prefeitura.relatos.repositories.RelatoRepository;
import com.prefeitura.relatos.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RelatoService {

    @Autowired
    private RelatoRepository relatoRepository;

    @Autowired
    private UserRepository userRepository;

    public RelatoResponseDTO criarRelato(RelatoRequestDTO dto){

        Optional<User> usuarioOpt = userRepository.findById(dto.usuarioId());
        if(usuarioOpt.isEmpty()) {
            throw new RuntimeException("Usuário não encontrado");
        }
        User usuario = usuarioOpt.get();

        Relato relato = Relato.builder()
                .titulo(dto.titulo())
                .descricao(dto.descricao())
                .categoria(dto.categoria())
                .usuario(usuario)
                .dataCriacao(LocalDateTime.now())
                .build();

        Relato salvo = relatoRepository.save(relato);

        return new RelatoResponseDTO(
                salvo.getId(),
                salvo.getTitulo(),
                salvo.getDescricao(),
                salvo.getCategoria(),
                salvo.getDataCriacao(),
                salvo.getUsuario().getNome()
        );
    }
    public List<RelatoResponseDTO> listarRelatos() {
        List<Relato> relatos = relatoRepository.findAll();

        return relatos.stream().map(relato -> new RelatoResponseDTO(
                relato.getId(),
                relato.getTitulo(),
                relato.getDescricao(),
                relato.getCategoria(),
                relato.getDataCriacao(),
                relato.getUsuario().getNome()
        )).collect(Collectors.toList());
    }
    public RelatoResponseDTO atualizarRelato(Long id, RelatoRequestDTO dto) {
        Relato relato = relatoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Relato não encontrado"));

        relato.setTitulo(dto.titulo());
        relato.setDescricao(dto.descricao());
        relato.setCategoria(dto.categoria());

        Relato atualizado = relatoRepository.save(relato);

        return new RelatoResponseDTO(
                atualizado.getId(),
                atualizado.getTitulo(),
                atualizado.getDescricao(),
                atualizado.getCategoria(),
                atualizado.getDataCriacao(),
                atualizado.getUsuario().getNome()
        );
    }
    public void deletarRelato(Long id) {
        if (!relatoRepository.existsById(id)) {
            throw new RuntimeException("Relato não encontrado");
        }
        relatoRepository.deleteById(id);
    }

}
