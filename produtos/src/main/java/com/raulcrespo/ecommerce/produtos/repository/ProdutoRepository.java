package com.raulcrespo.ecommerce.produtos.repository;

import com.raulcrespo.ecommerce.produtos.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
