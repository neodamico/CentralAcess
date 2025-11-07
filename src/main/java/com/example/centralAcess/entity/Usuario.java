package com.example.centralAcess.entity;

import com.example.centralAcess.enums.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name="usuario")

public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_usuario")
    private Integer id_usuario;

    @Column(name="nome" , nullable = false)
    private String nome;

    @Column(name="email", nullable = false)
    private String email;

    @Column(name="cargo", nullable = false)
    private String cargo;

    @Enumerated(EnumType.STRING)
    @Column(name="role", nullable = false)
    private Role role;

    @Column(name="senha", nullable = false)
    private String senha;

    //solicitacao feita pelo Usuario
    @OneToMany(mappedBy = "usuario")
    private List<SolicitacaoAcesso> solicitacoes;

    //solicitacoes aprovadas por ele caso ele seja ADMIN
    @OneToMany(mappedBy = "aprovador")
    private List<SolicitacaoAcesso> aprovacoes;


}
