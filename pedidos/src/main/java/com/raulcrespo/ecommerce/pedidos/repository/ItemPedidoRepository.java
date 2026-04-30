package com.raulcrespo.ecommerce.pedidos.repository;

import com.raulcrespo.ecommerce.pedidos.model.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {
}
