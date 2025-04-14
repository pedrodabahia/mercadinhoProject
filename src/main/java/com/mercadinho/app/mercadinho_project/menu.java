package com.mercadinho.app.mercadinho_project;

import com.mercadinho.service.MercadinhoFacade;
import java.util.Scanner;

public class Menu {

    private MercadinhoFacade mercadinhoFacade;
    private Scanner scanner;

    public Menu() {
        // Instanciando a fachada, que vai controlar as operações do mercadinho
        this.mercadinhoFacade = new MercadinhoFacade();
        this.scanner = new Scanner(System.in);
    }

    public void exibir() {
        int opcao;
        
        // Exibe o menu inicial
        do {
            System.out.println("\n--- MENU MERCADINHO ---");
            System.out.println("1. Cadastrar Produto");
            System.out.println("2. Vender Produto");
            System.out.println("3. Listar Produtos");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarProduto();
                    break;
                case 2:
                    venderProduto();
                    break;
                case 3:
                    listarProdutos();
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 4);  // O menu vai continuar até a opção 4 (Sair)
    }

    // Método para cadastrar produto
    private void cadastrarProduto() {
        System.out.print("Nome do Produto: ");
        String nome = scanner.next();
        System.out.print("Preço do Produto: ");
        float preco = scanner.nextFloat();
        System.out.print("Quantidade do Produto: ");
        int quantidade = scanner.nextInt();
        
        // Chama o método da fachada para cadastrar o produto
        mercadinhoFacade.cadastrarProduto(nome, preco, quantidade);
    }

    // Método para vender produto
    private void venderProduto() {
        System.out.print("Nome do Produto: ");
        String nomeProduto = scanner.next();
        System.out.print("Quantidade a ser vendida: ");
        int quantidade = scanner.nextInt();

        // Chama o método da fachada para realizar a venda
        mercadinhoFacade.venderProduto(nomeProduto, quantidade);
    }

    // Método para listar produtos
    private void listarProdutos() {
        // Chama o método da fachada para listar os produtos
        mercadinhoFacade.listarProdutos();
    }
}
