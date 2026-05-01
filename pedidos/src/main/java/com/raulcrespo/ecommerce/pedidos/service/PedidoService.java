package com.raulcrespo.ecommerce.pedidos.service;

import com.raulcrespo.ecommerce.pedidos.client.ServicoBancarioClient;
import com.raulcrespo.ecommerce.pedidos.model.Pedido;
import com.raulcrespo.ecommerce.pedidos.repository.ItemPedidoRepository;
import com.raulcrespo.ecommerce.pedidos.repository.PedidoRepository;
import com.raulcrespo.ecommerce.pedidos.validator.PedidoValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ItemPedidoRepository itemPedidoRepository;
    private final PedidoValidator pedidoValidator;
    private final ServicoBancarioClient servicoBancarioClient;

    @Transactional
    public Pedido criarPedido(Pedido pedido) {
        pedidoValidator.validar(pedido);
        realizarPersistencia(pedido);
        enviarSolicitacaoPagamento(pedido);

        return pedido;
    }

    private void enviarSolicitacaoPagamento(Pedido pedido) {
        var chavePagamento = servicoBancarioClient.solicitarPagamento(pedido);
        pedido.setChavePagamento(chavePagamento);
    }

    private void realizarPersistencia(Pedido pedido) {
        pedidoRepository.save(pedido);
        itemPedidoRepository.saveAll(pedido.getItens());
    }

//    public Optional<Pedido> obterPorCodigo(Long codigo) {
//        return pedidoRepository.findById(codigo);
//    }
}
