package com.mercadinho.app.mercadinho_project;

public class App {
    public static void main(String[] args) {
    	
    	menu menu = new menu();    	
    	boolean val = false;
    	
    	while(val == false) {
    	int opc = menu.visor();
    	val = menu.escolha(opc);
    	}    	
    	//repositorio.setName("foi");
    	
       
    }
}
