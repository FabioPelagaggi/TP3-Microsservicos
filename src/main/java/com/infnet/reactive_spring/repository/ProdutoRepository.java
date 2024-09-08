package com.infnet.reactive_spring.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

import com.infnet.reactive_spring.model.Produto;

@Repository
public interface ProdutoRepository extends R2dbcRepository<Produto, Long> {
    // Métodos CRUD reativos fornecidos pelo R2dbcRepository
}
