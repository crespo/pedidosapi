package com.raulcrespo.ecommerce.clientes.service;

import com.raulcrespo.ecommerce.clientes.model.Cliente;
import com.raulcrespo.ecommerce.clientes.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository repository;

    public Cliente salvar(Cliente cliente) {
        return repository.save(cliente);
    }

    public Optional<Cliente> obterPorCodigo(Long codigo) {
        return repository.findById(codigo);
    }
}
