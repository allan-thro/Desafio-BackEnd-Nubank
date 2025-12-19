package com.backend.challenge.nubank.contatos.controller;

import com.backend.challenge.nubank.contatos.service.ClienteService;
import com.backend.challenge.nubank.contatos.model.ContatoRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/contatos")
@RestController

public class ContatoController {

    private final ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Void> cadastrarContato(@RequestBody ContatoRequestDTO contatoDTO){
        clienteService.cadastrarContato(contatoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


}
