package com.mercadinho.app.mercadinho_project;


import com.mercadinho.repository.ProdutoRepository;
import com.mercadinho.repository.vendaRepository;
import java.util.Scanner;
import com.mercadinho.servicos.*;

public class menu {
	ProdutoRepository produtos = new ProdutoRepository();
	vendaRepository vendas = new vendaRepository();
	lista listagem = new lista();
	vendaRelatorio relatvendas = new vendaRelatorio();
	excluirProduto excluindo = new excluirProduto();
	
	public int visor(){
    	Scanner scanner = new Scanner(System.in);
    	
    	System.out.println(
    	"\n--------------------------------------\n"
    	+ "Seja bem vindo ao menu do mercadinho!! \n"+
    	"SELECIONE UMA OPERAÇÃO: \n"+
    	"----------------------- \n"+
    	"[1] Adicionar produto \n"+
    	"[2] Listar produtos \n"+
    	"[3] Excluir produto \n"+
    	"[4] Realizar venda \n"+
    	"[5] Ver detalhes de Uma venda \n"+
    	"[0] - Sair \n"
    	+ "--------------------------------------");
    	
    	int opcao = scanner.nextInt();
    	return opcao;
    	
	}
	
	public boolean escolha(int escolha) {
		switch(escolha) {
		case 1:
			produtos.cadastrarProduto();
			return false;
		case 2: 
			listagem.listagem();
			return false;
		case 3:
			excluindo.excluir();
			return false;
		case 4:
			vendas.vender();
			return false;
		case 5: 
			relatvendas.relatorio();
			return false;
		case 0:
			return true;
			default:
				return false;
		}
	}
	
}
