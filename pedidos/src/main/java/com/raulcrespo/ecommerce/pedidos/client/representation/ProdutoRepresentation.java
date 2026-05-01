package com.raulcrespo.ecommerce.pedidos.client.representation;

import java.math.BigDecimal;

public record ProdutoRepresentation(Long codigo, String nome, BigDecimal valorUnitario) {

}
