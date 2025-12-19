package com.backend.challenge.nubank.contatos.infrastruct.entity;

import com.backend.challenge.nubank.contatos.model.ClienteRequestDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Table(name = "cliente")
@Entity

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Cliente {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank @Column(unique = true) private String email;
    @NotBlank @Column(unique = true) private String cpf;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<Contato> contatos = new ArrayList<>();

    @NotBlank private String localidade;
    @NotBlank private String telefone;
    @NotBlank private String nome;

    public Cliente (ClienteRequestDTO dados){
        this.localidade = dados.localidade();
        this.telefone = dados.telefone();
        this.email = dados.email();
        this.nome = dados.nome();
        this.cpf = dados.cpf();
    }

    public void adicionarContato(Contato contato){
        contato.setCliente(this);
        contatos.add(contato);
    }

}
