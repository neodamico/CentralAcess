package com.example.centralAcess.dto;

import com.example.centralAcess.enums.Role;

public record LoginResponseDTO(
        Integer id,
        String nome,
        String email,
        String cargo,
        Role role
) {}
