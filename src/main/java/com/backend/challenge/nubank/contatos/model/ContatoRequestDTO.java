package com.backend.challenge.nubank.contatos.model;

public record ContatoRequestDTO(
        String telefone,
        String email,
        String nome,
        String cpf,
        Long id
) {}