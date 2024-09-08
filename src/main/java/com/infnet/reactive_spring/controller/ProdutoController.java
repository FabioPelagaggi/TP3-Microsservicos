package com.infnet.reactive_spring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.infnet.reactive_spring.model.Produto;
import com.infnet.reactive_spring.service.ProdutoService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    // Criar novo produto
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Produto> criarProduto(@RequestBody Produto produto) {
        return produtoService.save(produto);
    }

    // Atualizar produto existente
    @PutMapping("/{id}")
    public Mono<Produto> atualizarProduto(@PathVariable Long id, @RequestBody Produto produto) {
        return produtoService.updateById(id, produto);
    }

    // Excluir produto
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> excluirProduto(@PathVariable Long id) {
        return produtoService.deleteById(id);
    }

    // Listar todos os produtos
    @GetMapping
    public Flux<Produto> listarProdutos() {
        return produtoService.findAll();
    }

    // Buscar produto por ID
    @GetMapping("/{id}")
    public Mono<Produto> buscarProdutoPorId(@PathVariable Long id) {
        return produtoService.findById(id);
    }
}
