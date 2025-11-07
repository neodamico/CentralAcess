package com.example.centralAcess.controller;

import com.example.centralAcess.dto.SistemaRequestDTO;
import com.example.centralAcess.dto.SistemaResponseDTO;
import com.example.centralAcess.service.SistemaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sistemas")
public class SistemaController {

    private final SistemaService sistemaService;

    public SistemaController(SistemaService sistemaService) {
        this.sistemaService = sistemaService;
    }

    @PostMapping
    public SistemaResponseDTO criar(@RequestBody SistemaRequestDTO dto) {
        return sistemaService.criarSistema(dto);
    }

    @GetMapping
    public List<SistemaResponseDTO> listarTodos() {
        return sistemaService.listarTodos();
    }

    @GetMapping("/{id}")
    public SistemaResponseDTO buscarPorId(@PathVariable Integer id) {
        return sistemaService.buscarPorId(id);
    }
}
