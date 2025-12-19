package com.backend.challenge.nubank.contatos.infrastruct.repository;

import com.backend.challenge.nubank.contatos.infrastruct.entity.Cliente;
import com.backend.challenge.nubank.contatos.infrastruct.entity.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query("SELECT cont FROM Cliente cli JOIN cli.contatos cont WHERE cli = :cliente")
    List<Contato> buscarContatoPorCliente(Cliente cliente);

}
