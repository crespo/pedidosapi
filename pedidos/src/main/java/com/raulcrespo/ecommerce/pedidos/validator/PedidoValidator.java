package com.raulcrespo.ecommerce.pedidos.validator;

import com.raulcrespo.ecommerce.pedidos.client.ClientesClient;
import com.raulcrespo.ecommerce.pedidos.client.ProdutosClient;
import com.raulcrespo.ecommerce.pedidos.client.representation.ClienteRepresentation;
import com.raulcrespo.ecommerce.pedidos.client.representation.ProdutoRepresentation;
import com.raulcrespo.ecommerce.pedidos.model.ItemPedido;
import com.raulcrespo.ecommerce.pedidos.model.Pedido;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class PedidoValidator {

    private final ProdutosClient produtosClient;
    private final ClientesClient clientesClient;

    public void validar(Pedido pedido) {
    Long codigoCliente = pedido.getCodigoCliente();
    validarCliente(codigoCliente);
    pedido.getItens().forEach(this::validarItem);
//        List<Long> codigosProdutos = pedido.getItens().stream().map(i -> i.getCodigoProduto()).toList();
//
//        codigosProdutos.forEach(codigoProduto -> {
//            ResponseEntity<ProdutoRepresentation> response = produtosClient.obterDados(codigoProduto);
//            ProdutoRepresentation produto = response.getBody();
//
//        });
    }

    private void validarCliente(Long codigoCliente) {
        try {
            var response = clientesClient.obterDados(codigoCliente);
            ClienteRepresentation cliente = response.getBody();
            log.info("Cliente de código: [{}] encontrado: [{}]", cliente.codigo(), cliente.nome());
        } catch (FeignException.NotFound e) {
            log.error("Cliente não encontrado");
        }

    }

    private void validarItem(ItemPedido item) {
        try {
            var response = produtosClient.obterDados(item.getCodigoProduto());
            ProdutoRepresentation produto = response.getBody();
            log.info("Produto de código: [{}] encontrado: [{}]", produto.codigo(), produto.nome());
        } catch (FeignException.NotFound e) {
            log.error("Produto não encontrado");
        }
    }
}
