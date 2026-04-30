package com.raulcrespo.ecommerce.pedidos.controller.mappers;

import com.raulcrespo.ecommerce.pedidos.controller.dto.ItemPedidoDTO;
import com.raulcrespo.ecommerce.pedidos.model.ItemPedido;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ItemPedidoMapper {
    ItemPedido map(ItemPedidoDTO dto);
}
