package com.example.centralAcess.service;

import com.example.centralAcess.dto.LoginResponseDTO;
import com.example.centralAcess.dto.UsuarioRequestDTO;
import com.example.centralAcess.dto.UsuarioResponseDTO;
import com.example.centralAcess.entity.Usuario;
import com.example.centralAcess.repository.UsuarioRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    // Injeção pelo construtor (boa prática)
    public UsuarioService(UsuarioRepository usuarioRepository, BCryptPasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // Criar um novo usuário
    public UsuarioResponseDTO criarUsuario(UsuarioRequestDTO dto) {

        Usuario usuario = new Usuario();
        usuario.setNome(dto.nome());
        usuario.setEmail(dto.email());
        usuario.setCargo(dto.cargo());
        usuario.setRole(dto.role());
        usuario.setSenha(passwordEncoder.encode(dto.senha())); // <<< AQUI AGORA USA O BEAN

        usuarioRepository.save(usuario);

        return new UsuarioResponseDTO(
                usuario.getId_usuario(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getCargo(),
                usuario.getRole()
        );
    }

    // Buscar usuario por ID
    public UsuarioResponseDTO buscarPorId(Integer id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        return new UsuarioResponseDTO(
                usuario.getId_usuario(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getCargo(),
                usuario.getRole()
        );
    }

    //logica de login
    public LoginResponseDTO login(String email, String senha) {

        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Email não encontrado"));

        if (!passwordEncoder.matches(senha, usuario.getSenha())) {
            throw new RuntimeException("Senha incorreta");
        }

        return new LoginResponseDTO(
                usuario.getId_usuario(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getCargo(),
                usuario.getRole()
        );
    }

}
