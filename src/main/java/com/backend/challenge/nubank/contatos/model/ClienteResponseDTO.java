package com.backend.challenge.nubank.contatos.model;

import com.backend.challenge.nubank.contatos.infrastruct.entity.Cliente;
import com.backend.challenge.nubank.contatos.infrastruct.entity.Contato;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public record ClienteResponseDTO(
        List<ContatoResponceDTO> contatos,
        String telefone,
        String nome
){

    public static ClienteResponseDTO fromEntity(Cliente cliente){

        List<Contato> listContato = cliente.getContatos();
        List<ContatoResponceDTO> listContatoDTO = listContato.stream()
                .map(ContatoResponceDTO::fromEntity)
                .collect(Collectors.toList());

        return new ClienteResponseDTO(
            listContatoDTO,
            cliente.getTelefone(),
            cliente.getNome()
        );

    }

}
