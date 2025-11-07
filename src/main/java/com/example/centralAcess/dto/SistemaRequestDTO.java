package com.example.centralAcess.dto;

import com.example.centralAcess.enums.NivelCriticidade;

public record SistemaRequestDTO(
        String nome,
        String descricao,
        NivelCriticidade nivelCriticidade
) {}

