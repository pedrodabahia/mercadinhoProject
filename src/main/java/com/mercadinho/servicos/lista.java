package com.mercadinho.servicos;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class lista {

	public void listagem() {
		
		String caminho = "src/main/java/com/mercadinho/data/produto.json";
		JsonArray vendas = new JsonArray();
		Scanner scanner = new Scanner(System.in);
		int conter = 0;
		
		try {
			File file = new File(caminho);
			FileReader reader = new FileReader(file);
			JsonElement elemento = JsonParser.parseReader(reader);
			vendas = elemento.getAsJsonArray();
			System.out.println("LISTA DE PRODUTOS: \n"+
								"------------------- \n");
			for(JsonElement element: vendas) {
				conter++;
				JsonObject vendaProduct = element.getAsJsonObject();
				String nome = vendaProduct.get("name").getAsString();
				String quant = vendaProduct.get("quantidade").getAsString();
				System.out.println("* ["+conter+"] "+nome+" ["+quant+"und]");
			}
			System.out.println("\n");
			
			}catch(IOException e){ e.printStackTrace();}
		
	
		
	}
	
	public String produtoLista(String namber) {
			
		int numero = Integer.parseInt(namber);
		
		String caminho = "src/main/java/com/mercadinho/data/produto.json";
		JsonArray vendas = new JsonArray();
		Scanner scanner = new Scanner(System.in);
		int conter = 0;
		
		
		try {
			File file = new File(caminho);
			FileReader reader = new FileReader(file);
			JsonElement elemento = JsonParser.parseReader(reader);
			vendas = elemento.getAsJsonArray();
			
			for(JsonElement element: vendas) {
				conter++;
				JsonObject vendaProduct = element.getAsJsonObject();
				String nome = vendaProduct.get("name").getAsString();
				if(numero == conter) {
					return nome;
				}
			}
	
		}catch(IOException e){ e.printStackTrace();}
		return caminho;
		
	}
	public float produtoValor(String namber) {
		
		int numero = Integer.parseInt(namber);
		
		String caminho = "src/main/java/com/mercadinho/data/produto.json";
		JsonArray vendas = new JsonArray();
		Scanner scanner = new Scanner(System.in);
		int conter = 0;
		
		try {
			File file = new File(caminho);
			FileReader reader = new FileReader(file);
			JsonElement elemento = JsonParser.parseReader(reader);
			vendas = elemento.getAsJsonArray();
			
			for(JsonElement element: vendas) {
				conter++;
				JsonObject vendaProduct = element.getAsJsonObject();
				float valor = vendaProduct.get("valorPorUnd").getAsFloat();
				if(numero == conter) {
					return valor;
				}
			}
			}catch(IOException e){ e.printStackTrace();}
			return 0;
		}
				public int produtoQuantidade(String namber) {
					
					int numero = Integer.parseInt(namber);
					
					String caminho = "src/main/java/com/mercadinho/data/produto.json";
					JsonArray quant = new JsonArray();
					Scanner scanner = new Scanner(System.in);
					int conter = 0;
					
					try {
						File file = new File(caminho);
						FileReader reader = new FileReader(file);
						JsonElement elemento = JsonParser.parseReader(reader);
						quant = elemento.getAsJsonArray();
						
						for(JsonElement element: quant) {
							conter++;
							JsonObject quantProduct = element.getAsJsonObject();
							int quantidade = quantProduct.get("quantidade").getAsInt();
							if(numero == conter) {
								return quantidade;
							}

			}
	
		}catch(IOException e){ e.printStackTrace();}
		return 0;
		
	}

				public void relatorioVenda() {
						
						String caminho = "src/main/java/com/mercadinho/data/vendas.json";
						JsonArray vendas = new JsonArray();
						Scanner scanner = new Scanner(System.in);
						
						int conter = 0;

						
						try {
							File file = new File(caminho);
							FileReader reader = new FileReader(file);
							JsonElement elemento = JsonParser.parseReader(reader);
							vendas = elemento.getAsJsonArray();
							System.out.println("RELATORIO DE VENDAS: \n"+"------------------- \n");
							
							for(JsonElement element: vendas) {
								conter++;
								JsonObject vendaProduct = element.getAsJsonObject();
								String produto = vendaProduct.get("produto").getAsString();
								float valor = vendaProduct.get("valorTotal").getAsFloat();
								int quant = vendaProduct.get("quantidade").getAsInt();
								System.out.println("^^^^^^^^^^^^^^^^^^^^"
										+"\n|PRODUTO: "+produto
										+"\n|QUANTIDADE VENDIDA: "+quant+"und"
										+"\n|VALOR TOTAL: "+valor
										+"\n--------------------"
										);
							}
							
							}catch(IOException e){ e.printStackTrace();}
						
		}

}
