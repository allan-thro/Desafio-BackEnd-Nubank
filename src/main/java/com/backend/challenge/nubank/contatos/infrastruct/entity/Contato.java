package com.backend.challenge.nubank.contatos.infrastruct.entity;

import com.backend.challenge.nubank.contatos.model.ContatoRequestDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "contato")
@Entity

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Contato {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Cliente cliente;

    @NotBlank @Column(unique = true) private String email;
    @NotBlank @Column(unique = true) private String cpf;

    @NotBlank private String telefone;
    @NotBlank private String nome;

    public Contato(ContatoRequestDTO dados){
        this.telefone = dados.telefone();
        this.email = dados.email();
        this.nome = dados.nome();
        this.cpf = dados.cpf();
    }

}
