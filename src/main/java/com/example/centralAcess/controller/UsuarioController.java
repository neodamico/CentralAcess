package com.example.centralAcess.controller;

import com.example.centralAcess.dto.LoginRequestDTO;
import com.example.centralAcess.dto.LoginResponseDTO;
import com.example.centralAcess.dto.UsuarioRequestDTO;
import com.example.centralAcess.dto.UsuarioResponseDTO;
import com.example.centralAcess.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public UsuarioResponseDTO criar(@RequestBody UsuarioRequestDTO dto) {
        return usuarioService.criarUsuario(dto);
    }

    @PostMapping("/login")
    public LoginResponseDTO login(@RequestBody LoginRequestDTO dto) {
        return usuarioService.login(dto.email(), dto.senha());
    }

    @GetMapping("/{id}")
    public UsuarioResponseDTO buscarPorId(@PathVariable Integer id) {
        return usuarioService.buscarPorId(id);
    }


}
