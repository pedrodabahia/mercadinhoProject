package com.mercadinho;

import com.mercadinho.servicos.MercadoFacade;

public class App {
    public static void main(String[] args) {
        // Criação de um repositório de produtos
        MercadoFacade menu = new MercadoFacade();        
        menu.menu();
    }
}