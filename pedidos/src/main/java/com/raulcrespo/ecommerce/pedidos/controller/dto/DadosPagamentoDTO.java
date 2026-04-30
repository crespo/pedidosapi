package com.raulcrespo.ecommerce.pedidos.controller.dto;

import com.raulcrespo.ecommerce.pedidos.model.enums.TipoPagamento;

public record DadosPagamentoDTO(String dados, TipoPagamento tipoPagamento) {
}
