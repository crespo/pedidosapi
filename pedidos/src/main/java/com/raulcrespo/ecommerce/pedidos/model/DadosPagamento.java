package com.raulcrespo.ecommerce.pedidos.model;

import com.raulcrespo.ecommerce.pedidos.model.enums.TipoPagamento;
import lombok.Data;

@Data
public class DadosPagamento {
    private String dados;
    private TipoPagamento tipoPagamento;
}
