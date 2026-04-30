package com.raulcrespo.ecommerce.clientes.repository;

import com.raulcrespo.ecommerce.clientes.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository  extends JpaRepository<Cliente, Long> {

}
