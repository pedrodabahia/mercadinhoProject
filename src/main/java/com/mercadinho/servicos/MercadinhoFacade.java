package com.mercadinho.service;

import com.mercadinho.model.Produto;
import com.mercadinho.repository.ProdutoRepository;

public class MercadinhoFacade {
    private ProdutoRepository produtoRepo;

    public MercadinhoFacade() {
        this.produtoRepo = new ProdutoRepository();
    }

    public void cadastrarProduto(String nome, double preco, int quantidade) {
        Produto produto = new Produto(nome, preco, quantidade);
        produtoRepo.salvar(produto);
    }

    public boolean venderProduto(String nome, int quantidade) {
        Produto produto = produtoRepo.buscarPorNome(nome);
        if (produto != null && produto.getQuantidade() >= quantidade) {
            produto.setQuantidade(produto.getQuantidade() - quantidade);
            produtoRepo.atualizar(produto);
            return true;
        }
        return false;
    }

    public void listarProdutos() {
        for (Produto p : produtoRepo.listarTodos()) {
            System.out.println(p);
        }
    }
}
