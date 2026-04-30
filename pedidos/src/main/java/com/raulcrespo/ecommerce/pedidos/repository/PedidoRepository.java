package com.raulcrespo.ecommerce.pedidos.repository;

import com.raulcrespo.ecommerce.pedidos.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
