package com.example.centralAcess.dto;

public record SolicitacaoAcessoResponseDTO(
        Integer id_acesso,
        String nomeUsuario,
        String nomeSistema,
        String status,
        String dataSolicitacao,
        String dataDecisao,
        String aprovador
) {}
