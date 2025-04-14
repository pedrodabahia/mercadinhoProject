package com.mercadinho.repository;

import java.util.Scanner;

public class ProdutoRepository {
    public void cadastrarProduto() {
        // Cria um objeto da classe utilitária que lida com arquivos JSON
        JsonUtil utilidade = new JsonUtil();

        // Chama o método de cadastro de produto da classe JsonUtil
        utilidade.cadastrarProduto(null);
    }
}