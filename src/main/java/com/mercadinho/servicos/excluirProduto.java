package com.mercadinho.servicos;

import com.mercadinho.repository.*;
import com.mercadinho.servicos.*;
import java.util.Scanner;

public class excluirProduto {
	lista listas = new lista();
	Scanner scanner = new Scanner(System.in);
	JsonUtil util = new JsonUtil();
	
	public void excluir() {
		System.out.println("Selecione o produto: ");
		listas.listagem();
		String opc = scanner.next();
		
		String product = listas.produtoLista(opc);
		System.out.println(product);
		util.removerProduto(product);
		
	}
	
}
