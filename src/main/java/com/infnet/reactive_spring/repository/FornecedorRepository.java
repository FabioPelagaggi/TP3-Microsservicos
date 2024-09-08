package com.infnet.reactive_spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.infnet.reactive_spring.model.Fornecedor;

@Repository
public interface FornecedorRepository extends CrudRepository<Fornecedor, Long> {
    // Métodos CRUD são fornecidos automaticamente pelo CrudRepository
}
