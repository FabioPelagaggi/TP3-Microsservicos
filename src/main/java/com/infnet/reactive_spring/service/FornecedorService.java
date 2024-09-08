package com.infnet.reactive_spring.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.infnet.reactive_spring.model.Fornecedor;
import com.infnet.reactive_spring.repository.FornecedorRepository;
@Service
public class FornecedorService {

    private final FornecedorRepository fornecedorRepository;

    public FornecedorService(FornecedorRepository fornecedorRepository) {
        this.fornecedorRepository = fornecedorRepository;
    }

    // Criar novo fornecedor
    public Fornecedor criarFornecedor(Fornecedor fornecedor) {
        return fornecedorRepository.save(fornecedor);
    }

    // Atualizar fornecedor existente
    public Optional<Fornecedor> atualizarFornecedor(Long id, Fornecedor fornecedorAtualizado) {
        return fornecedorRepository.findById(id)
            .map(fornecedorExistente -> {
                fornecedorExistente.setNome(fornecedorAtualizado.getNome());
                fornecedorExistente.setEndereco(fornecedorAtualizado.getEndereco());
                return fornecedorRepository.save(fornecedorExistente);
            });
    }

    // Excluir fornecedor
    public void excluirFornecedor(Long id) {
        fornecedorRepository.deleteById(id);
    }

    // Buscar fornecedor por ID
    public Optional<Fornecedor> buscarFornecedorPorId(Long id) {
        return fornecedorRepository.findById(id);
    }

    // Listar todos os fornecedores
    public Iterable<Fornecedor> listarFornecedores() {
        return fornecedorRepository.findAll();
    }
}