package com.raulcrespo.ecommerce.pedidos.service;

import com.raulcrespo.ecommerce.pedidos.model.Pedido;
import com.raulcrespo.ecommerce.pedidos.repository.ItemPedidoRepository;
import com.raulcrespo.ecommerce.pedidos.repository.PedidoRepository;
import com.raulcrespo.ecommerce.pedidos.validator.PedidoValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ItemPedidoRepository itemPedidoRepository;
    private final PedidoValidator pedidoValidator;

    public Pedido criarPedido(Pedido pedido) {
        pedidoRepository.save(pedido);
        itemPedidoRepository.saveAll(pedido.getItens());

        return pedido;
    }

//    public Optional<Pedido> obterPorCodigo(Long codigo) {
//        return pedidoRepository.findById(codigo);
//    }
}
