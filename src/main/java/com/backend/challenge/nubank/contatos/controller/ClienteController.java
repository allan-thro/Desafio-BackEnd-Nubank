package com.backend.challenge.nubank.contatos.controller;

import com.backend.challenge.nubank.contatos.service.ClienteService;
import com.backend.challenge.nubank.contatos.model.ClienteRequestDTO;
import com.backend.challenge.nubank.contatos.model.ClienteResponseDTO;
import com.backend.challenge.nubank.contatos.model.ContatoResponceDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/clientes")
@RestController

public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Void> cadastrarCliente(@RequestBody ClienteRequestDTO clienteDTO){
        clienteService.cadastrarCliente(clienteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponseDTO>> listarTodosClientes(){
        return ResponseEntity.ok(clienteService.listarTodosClientes());
    }

    @GetMapping("/{clienteId}/contatos")
    public ResponseEntity<List<ContatoResponceDTO>> listarContatosDeCliente(@PathVariable Long clienteId){
        return ResponseEntity.ok(clienteService.listarContatosDeCliente(clienteId));
    }

}
