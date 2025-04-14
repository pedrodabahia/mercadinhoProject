package com.mercadinho.app.mercadinho_project;

import com.mercadinho.servicos.MercadoFacade;

public class App {
    public static void main(String[] args) {
    MercadoFacade mercado = new MercadoFacade(); 
    	boolean val = false;
    	
    	while(val == false) {
    	int opc = mercado.menuFacade();
    	val = mercado.escolhaFacade(opc);    	}    	
    	
    	//repositorio.setName("foi");
    	
       
    }
}
