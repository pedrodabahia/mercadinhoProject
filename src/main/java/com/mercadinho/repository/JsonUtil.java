package com.mercadinho.repository;

import java.io.*;
import java.util.Scanner;
import com.google.gson.*;
import java.util.*;

public class JsonUtil {


public void cadastrarProduto(String operacao) {
	
	
	String caminho = "src/main/java/com/mercadinho/data/produto.json";
	Gson gson = new GsonBuilder().setPrettyPrinting().create();
	JsonArray produtos = new JsonArray();
	Scanner scanner = new Scanner(System.in);
	
	System.out.println("Nome do Produto:");
	String produtoNome = scanner.nextLine();
	
	
	try {
		File file = new File(caminho);
		
			if(file.exists()) {
				
				FileReader reader = new FileReader(file);
				JsonElement elemento = JsonParser.parseReader(reader);
				
				if(elemento.isJsonArray()) {produtos = elemento.getAsJsonArray();
				}reader.close();
				
			}
		
		String produtoNovo = produtoNome;
		boolean checagem = false;
		int option = 0;
		
		for(JsonElement produtoElem : produtos) {
			JsonObject produto = produtoElem.getAsJsonObject();
			if(produto.get("name").getAsString().equalsIgnoreCase(produtoNovo)) {
					
					System.out.println("Esse produto já existe no estoque, deseja atualiza-lo? \n"+"[1] SIM \n"+"[2] NÃO /n");
					option = scanner.nextInt();
						
					if(option == 1) {
						System.out.println("Quantidade:");
						int produtoQuantidade = scanner.nextInt();
						
						System.out.println("Valor por unidade:");
						float valorPorUnd = scanner.nextFloat();
						 	
						produto.addProperty("quantidade",produtoQuantidade);
						produto.addProperty("valorPorUnd",valorPorUnd);
						checagem = true;
						break;
						
					}else {
						checagem = false;
						break;
					}
					
				}
			}
			
		if(!checagem) {
			
			System.out.println("Quantidade:");
			int produtoQuantidade = scanner.nextInt();
			
			System.out.println("Valor por Unidade:");
			float valorPorUnd = scanner.nextFloat();
			
			
		
			JsonObject novoProduto = new JsonObject();
			novoProduto.addProperty("name", produtoNovo);
			novoProduto.addProperty("quantidade", produtoQuantidade);
			novoProduto.addProperty("valorPorUnd", valorPorUnd);
			produtos.add(novoProduto);
			}
			
		FileWriter writer = new FileWriter(caminho);
		gson.toJson(produtos,writer);
		writer.close();
			
		System.out.println(checagem ? "PRODUTO ATUALIZADO COM SUCESSO \n" : "PRODUTO ADICIONADO CMO SUCESSO!!");
		
		}catch(IOException e) {
			e.printStackTrace();
	
		} 
	
	
	
}

public void cadastrarVenda(String produto, float valorTotal, int quantidade) {
	
	
	String caminho = "src/main/java/com/mercadinho/data/vendas.json";
	Gson gson = new GsonBuilder().setPrettyPrinting().create();
	JsonArray produtos = new JsonArray();
	
	String produtoNome = produto;
	
	
	try {
		File file = new File(caminho);
		
			if(file.exists()) {
				
				FileReader reader = new FileReader(file);
				JsonElement elemento = JsonParser.parseReader(reader);
				
				if(elemento.isJsonArray()) {produtos = elemento.getAsJsonArray();
				}reader.close();
				
			}
		
		String produtoNovo = produtoNome;
		boolean checagem = false;
		int option = 0;
		int idVendaAtual = 0;
		int vendaAnterior = 0;
		
		
			JsonObject novoProduto = new JsonObject();
			novoProduto.addProperty("produto", produto);
			novoProduto.addProperty("quantidade", quantidade);
			novoProduto.addProperty("valorTotal", valorTotal);
			produtos.add(novoProduto);
			
			
		FileWriter writer = new FileWriter(caminho);
		gson.toJson(produtos,writer);
		writer.close();
			
		System.out.println("\n VENDA CADASTRADA COM SUCESSO");

		
		}catch(IOException e) {
			e.printStackTrace();
	
		} 
	
	
	
}

public void atualizarProduto(String produtoVenda, int quantidadeVendida) {
	
	
	String caminho = "src/main/java/com/mercadinho/data/produto.json";
	Gson gson = new GsonBuilder().setPrettyPrinting().create();
	JsonArray produtos = new JsonArray();
	Scanner scanner = new Scanner(System.in);
	
	String produtoNome = produtoVenda;
	
	
	try {
		File file = new File(caminho);
		
			if(file.exists()) {
				
				FileReader reader = new FileReader(file);
				JsonElement elemento = JsonParser.parseReader(reader);
				
				if(elemento.isJsonArray()) {produtos = elemento.getAsJsonArray();
				}reader.close();
				
			}
		
		String produtoNovo = produtoNome;
		boolean checagem = false;
		int option = 0;
		
		for(JsonElement produtoElem : produtos) {
			JsonObject produto = produtoElem.getAsJsonObject();
			if(produto.get("name").getAsString().equalsIgnoreCase(produtoNovo)) {
				
						produto.addProperty("quantidade", produto.get("quantidade").getAsInt() - quantidadeVendida);
						checagem = true;
						break;
						
					}else {
						checagem = false;
						break;
					}
					
				}
			
		FileWriter writer = new FileWriter(caminho);
		gson.toJson(produtos,writer);
		writer.close();
			
		System.out.println(checagem ? "PRODUTO ATUALIZADO COM SUCESSO \n" : "PRODUTO ADICIONADO CMO SUCESSO!!");
		
		}catch(IOException e) {
			e.printStackTrace();
	
		} 
}

public void removerProduto(String produtoExcluido) {
	String caminho = "src/main/java/com/mercadinho/data/produto.json";
	Gson gson = new GsonBuilder().setPrettyPrinting().create();
	JsonArray produtos = new JsonArray();
	String produtoNome = produtoExcluido;
	try {
		File file = new File(caminho);
			if(file.exists()) {
				
				FileReader reader = new FileReader(file);
				JsonElement elemento = JsonParser.parseReader(reader);
				
				if(elemento.isJsonArray()) {produtos = elemento.getAsJsonArray();
				}reader.close();
				
			}
			
			Iterator<JsonElement> iterator = produtos.iterator();
			
			while(iterator.hasNext()){
				JsonObject produto =iterator.next().getAsJsonObject();
				String name = produto.get("name").getAsString();
				if(name.equalsIgnoreCase(produtoExcluido.trim()))
				{
					iterator.remove();
					System.out.println("\nITEM EXCLUIDO COM SUCESSO \n");
				}
					
				}
			FileWriter writer = new FileWriter(file);
			gson.toJson(produtos, writer);
			writer.flush();
			writer.close();

		}catch(IOException e) {
			e.printStackTrace();
	
		} 
}
}
