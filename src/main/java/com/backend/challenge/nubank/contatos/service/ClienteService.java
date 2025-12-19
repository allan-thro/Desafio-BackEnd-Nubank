package com.backend.challenge.nubank.contatos.service;

import com.backend.challenge.nubank.contatos.infrastruct.entity.Cliente;
import com.backend.challenge.nubank.contatos.infrastruct.entity.Contato;
import com.backend.challenge.nubank.contatos.infrastruct.repository.ClienteRepository;
import com.backend.challenge.nubank.contatos.model.ClienteRequestDTO;
import com.backend.challenge.nubank.contatos.model.ClienteResponseDTO;
import com.backend.challenge.nubank.contatos.model.ContatoRequestDTO;
import com.backend.challenge.nubank.contatos.model.ContatoResponceDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class ClienteService {

    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public void cadastrarCliente(ClienteRequestDTO clienteDTO){
        repository.save(new Cliente(clienteDTO));
    }

    public void cadastrarContato(ContatoRequestDTO contatoDTO){

        Long id = contatoDTO.id();
        Optional<Cliente> cliente = repository.findById(id);

        if(cliente.isEmpty()){
            throw new IllegalArgumentException("Cliente não encontrado");
        }

        Cliente clienteAchado = cliente.get();
        clienteAchado.adicionarContato(new Contato(contatoDTO));

        repository.save(clienteAchado);

    }

    public List<ClienteResponseDTO> listarTodosClientes(){

        List<ClienteResponseDTO> listClienteDTO = new ArrayList<>();
        List<Cliente> listClientes = repository.findAll();

        for(Cliente cliente : listClientes){
            listClienteDTO.add(ClienteResponseDTO.fromEntity(cliente));
        }

        return listClienteDTO;

    }

    public List<ContatoResponceDTO> listarContatosDeCliente(Long id){

        Optional<Cliente> cliente = repository.findById(id);

        if(cliente.isEmpty()){
            throw new IllegalArgumentException("Cliente não encontrado");
        }

        Cliente clienteAchado = cliente.get();

        List<Contato> contatos = repository.buscarContatoPorCliente(clienteAchado);
        List<ContatoResponceDTO> listContatoDTO = contatos.stream()
                .map(ContatoResponceDTO::fromEntity)
                .collect(Collectors.toList());

        return listContatoDTO;

    }
}
