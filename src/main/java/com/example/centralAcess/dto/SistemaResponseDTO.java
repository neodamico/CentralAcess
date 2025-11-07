package com.example.centralAcess.dto;

import com.example.centralAcess.enums.NivelCriticidade;

public record SistemaResponseDTO(
        Integer id,
        String nome,
        String descricao,
        NivelCriticidade nivelCriticidade
) {}
