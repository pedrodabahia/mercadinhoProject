package com.mercadinho.repository;

import com.mercadinho.servicos.*;
import java.util.Scanner;

public class vendaRepository {

	JsonUtil util = new JsonUtil();
	lista listagem = new lista();
	Scanner scanner = new Scanner(System.in);
	
	
	public void vender() {
		System.out.println("Qual  item da venda? \n");
		listagem.listagem();
		String namber = scanner.next();
		String produto = listagem.produtoLista(namber);
		int quantidade = listagem.produtoQuantidade(namber);
		
		System.out.println("Você escolheu o produto: "+produto+"  ["+quantidade+"und]"+"\n Quantas unidades desja?");
		int unidade = scanner.nextInt();
		while(unidade > listagem.produtoQuantidade(namber)) {
			System.out.println("\nEstoque indisponivel, quantidade disponivel no estoque: "
								+listagem.produtoQuantidade(namber)+
								"\n Quantas unidades deseja? \n");
			unidade = scanner.nextInt();
			scanner.nextLine();			
		}
		
		
		
		System.out.println("\n Sua compra deu um total de: "
							+listagem.produtoValor(namber)*unidade+
							"\n deseja confirmar acompra?"+
							" \n [1] SIM "
							+"\n [2] NÃO \n");
		int confirm = scanner.nextInt();
		
		if(confirm == 1) {
			JsonUtil vendendo = new JsonUtil();
			vendendo.cadastrarVenda(listagem.produtoLista(namber), listagem.produtoValor(namber)*unidade, unidade);
			util.atualizarProduto(listagem.produtoLista(namber), unidade);
		}
			
		
		
	}
	
	
}
