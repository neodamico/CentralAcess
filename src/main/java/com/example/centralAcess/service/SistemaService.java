package com.example.centralAcess.service;

import com.example.centralAcess.dto.SistemaRequestDTO;
import com.example.centralAcess.dto.SistemaResponseDTO;
import com.example.centralAcess.entity.Sistema;
import com.example.centralAcess.repository.SistemaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SistemaService {

    private final SistemaRepository sistemaRepository;

    public SistemaService(SistemaRepository sistemaRepository) {
        this.sistemaRepository = sistemaRepository;
    }

    public SistemaResponseDTO criarSistema(SistemaRequestDTO dto) {

        Sistema sistema = new Sistema();
        sistema.setNome(dto.nome());
        sistema.setDescricao(dto.descricao());
        sistema.setNivelCriticidade(dto.nivelCriticidade());

        sistemaRepository.save(sistema);

        return new SistemaResponseDTO(
                sistema.getId(),
                sistema.getNome(),
                sistema.getDescricao(),
                sistema.getNivelCriticidade()
        );
    }

    public List<SistemaResponseDTO> listarTodos() {
        return sistemaRepository.findAll().stream()
                .map(sistema -> new SistemaResponseDTO(
                        sistema.getId(),
                        sistema.getNome(),
                        sistema.getDescricao(),
                        sistema.getNivelCriticidade()
                ))
                .toList();
    }

    public SistemaResponseDTO buscarPorId(Integer id) {
        Sistema sistema = sistemaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sistema não encontrado"));

        return new SistemaResponseDTO(
                sistema.getId(),
                sistema.getNome(),
                sistema.getDescricao(),
                sistema.getNivelCriticidade()
        );
    }


}
