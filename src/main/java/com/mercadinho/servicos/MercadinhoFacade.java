package com.mercadinho.service;

import com.mercadinho.model.Produto;
import com.mercadinho.repository.ProdutoRepository;
import com.mercadinho.repository.vendaRepository;

public class MercadinhoFacade {
    private ProdutoRepository produtoRepo;
    private vendaRepository vendaRepo;

    public MercadinhoFacade() {
        this.produtoRepo = new ProdutoRepository();
        this.vendaRepo = new vendaRepository();
    }

    // Método para cadastrar produtos
    public void cadastrarProduto(String nome, float preco, int quantidade) {
        Produto produto = new Produto(nome, preco, quantidade);
        produtoRepo.cadastrarProduto(produto);
    }

    // Método para realizar venda
    public void venderProduto(String nomeProduto, int quantidade) {
        vendaRepo.vender(nomeProduto, quantidade);
    }

    // Método para listar produtos
    public void listarProdutos() {
        produtoRepo.listarProdutos();
    }

    // Outros métodos que são necessários para o funcionamento do mercadinho
    // ...
}
