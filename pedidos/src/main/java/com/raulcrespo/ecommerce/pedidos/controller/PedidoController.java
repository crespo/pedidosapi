package com.raulcrespo.ecommerce.pedidos.controller;

import com.raulcrespo.ecommerce.pedidos.controller.dto.NovoPedidoDTO;
import com.raulcrespo.ecommerce.pedidos.controller.mappers.PedidosMapper;
import com.raulcrespo.ecommerce.pedidos.model.Pedido;
import com.raulcrespo.ecommerce.pedidos.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pedidos")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoService pedidoService;
    private final PedidosMapper pedidosMapper;

    @PostMapping
    public ResponseEntity<Object> criar(@RequestBody NovoPedidoDTO novoPedidoDTO) {
        var pedido = pedidosMapper.map(novoPedidoDTO);
        var novoPedido = pedidoService.criarPedido(pedido);
        return ResponseEntity.ok(novoPedido.getCodigo()); // fazer created
    }

//    @GetMapping("{codigo}")
//    public ResponseEntity<Pedido> obterDados(@PathVariable("codigo") Long codigo) {
//        return pedidoService
//                .obterPorCodigo(codigo)
//                .map(ResponseEntity::ok)
//                .orElseGet(() -> ResponseEntity.notFound().build());
//    }
}
