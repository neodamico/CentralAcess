package com.example.centralAcess.dto;

import com.example.centralAcess.enums.Role;

public record UsuarioRequestDTO (
        String nome,
        String email,
        String cargo,
        Role role,
        String senha
)  {}



