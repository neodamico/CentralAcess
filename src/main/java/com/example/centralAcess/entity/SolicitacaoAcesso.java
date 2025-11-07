package com.example.centralAcess.entity;

import com.example.centralAcess.enums.StatusSolicitacao;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@Entity
@Table(name="solicitacaoAcesso")

public class SolicitacaoAcesso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_acesso")
    private Integer id_acesso;

    @Enumerated(EnumType.STRING)
    @Column(name="status", nullable = false)
    private StatusSolicitacao status;

    @Column(name="dataSolicitacao", nullable = false)
    private LocalDate dataSolicitacao;

    @Column(name="dataDecisao")
    private LocalDate dataDecisao;

    //Quem pediu?
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="usuario_id", nullable = false)
    private Usuario usuario;

    //Qual sistema?
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "sistema_id", nullable = false)
    private Sistema sistema;

    //Quem aprovou?
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="aprovador_id" , nullable = false)
    private Usuario aprovador;

}
