package com.example.centralAcess.entity;

import com.example.centralAcess.enums.NivelCriticidade;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name="sistema")

public class Sistema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_sistema")
    private Integer id;

    @Column(name="nome" , nullable = false)
    private String nome;

    @Column(name="descricao")
    private String descricao;

    @Enumerated(EnumType.STRING)
    @Column(name="nivelCriticidade")
    private NivelCriticidade nivelCriticidade;

    @OneToMany(mappedBy = "sistema")
    private List<SolicitacaoAcesso> solicitacoes;

}
