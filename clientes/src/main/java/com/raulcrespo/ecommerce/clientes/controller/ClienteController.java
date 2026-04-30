package com.raulcrespo.ecommerce.clientes.controller;

import com.raulcrespo.ecommerce.clientes.model.Cliente;
import com.raulcrespo.ecommerce.clientes.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService service;

    @PostMapping
    public ResponseEntity<Cliente> salvar(@RequestBody Cliente cliente) { // validação, obrigatoriedade
        service.salvar(cliente);
        return ResponseEntity.ok(cliente); // retornar 201 e nao 200
    }

    @GetMapping("{codigo}")
    public ResponseEntity<Cliente> obterDados(@PathVariable("codigo") Long codigo) {
        return service
                .obterPorCodigo(codigo)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
