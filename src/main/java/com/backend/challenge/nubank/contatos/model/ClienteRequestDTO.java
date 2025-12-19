package com.backend.challenge.nubank.contatos.model;

public record ClienteRequestDTO(
        String localidade,
        String telefone,
        String email,
        String nome,
        String cpf
) {}