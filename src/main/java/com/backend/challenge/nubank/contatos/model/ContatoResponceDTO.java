package com.backend.challenge.nubank.contatos.model;

import com.backend.challenge.nubank.contatos.infrastruct.entity.Contato;

public record ContatoResponceDTO(String email, String nome) {

    public static ContatoResponceDTO fromEntity(Contato contato){
        return new ContatoResponceDTO(contato.getEmail(), contato.getNome());
    }

}
