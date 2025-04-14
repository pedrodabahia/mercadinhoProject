package com.mercadinho.repository;

import java.io.*;
import java.util.*;
import java.util.Scanner;
import com.google.gson.*;

public class JsonUtil {

    // Método para cadastrar produtos no arquivo JSON
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
                if(elemento.isJsonArray()) {
                    produtos = elemento.getAsJsonArray();
                }
                reader.close();
            }

            boolean checagem = false;
            for(JsonElement produtoElem : produtos) {
                JsonObject produto = produtoElem.getAsJsonObject();
                if(produto.get("name").getAsString().equalsIgnoreCase(produtoNome)) {
                    System.out.println("Esse produto já existe. Deseja atualizá-lo? [1] SIM / [2] NÃO");
                    int option = scanner.nextInt();
                    if(option == 1) {
                        System.out.println("Quantidade:");
                        int quantidade = scanner.nextInt();
                        System.out.println("Valor por unidade:");
                        double valor = scanner.nextDouble();
                        produto.addProperty("quantidade", quantidade);
                        produto.addProperty("valorPorUnd", valor);
                        checagem = true;
                        break;
                    } else {
                        checagem = false;
                        break;
                    }
                }
            }

            if(!checagem) {
                System.out.println("Quantidade:");
                int quantidade = scanner.nextInt();
                System.out.println("Valor por Unidade:");
                double valor = scanner.nextDouble();

                JsonObject novoProduto = new JsonObject();
                novoProduto.addProperty("name", produtoNome);
                novoProduto.addProperty("quantidade", quantidade);
                novoProduto.addProperty("valorPorUnd", valor);
                produtos.add(novoProduto);
            }

            FileWriter writer = new FileWriter(caminho);
            gson.toJson(produtos, writer);
            writer.close();
            System.out.println(checagem ? "\n ---------------------------------- \n"
                    + "Produto atualizado com sucesso!" : "Produto adicionado com sucesso!"
                    + "\n ----------------------------------"   );

        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    // Método para registrar uma venda no arquivo JSON de vendas
    public void cadastrarVenda(String produto, float valorTotal, int quantidade) {
        String caminho = "src/main/java/com/mercadinho/data/vendas.json";
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonArray vendas = new JsonArray();

        try {
            File file = new File(caminho);
            if(file.exists()) {
                FileReader reader = new FileReader(file);
                JsonElement elemento = JsonParser.parseReader(reader);
                if(elemento.isJsonArray()) {
                    vendas = elemento.getAsJsonArray();
                }
                reader.close();
            }

            JsonObject novaVenda = new JsonObject();
            novaVenda.addProperty("produto", produto);
            novaVenda.addProperty("quantidade", quantidade);
            novaVenda.addProperty("valorTotal", valorTotal);
            vendas.add(novaVenda);

            FileWriter writer = new FileWriter(caminho);
            gson.toJson(vendas, writer);
            writer.close();

            System.out.println("\n -------------------------------- \n"
                    + "Venda cadastrada com sucesso!"
                    + "\n -------------------------------- \n");
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    // Método para atualizar estoque após uma venda
    public void atualizarProduto(String produtoVenda, int quantidadeVendida) {
        String caminho = "src/main/java/com/mercadinho/data/produto.json";
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonArray produtos = new JsonArray();

        try {
            File file = new File(caminho);
            if(file.exists()) {
                FileReader reader = new FileReader(file);
                JsonElement elemento = JsonParser.parseReader(reader);
                if(elemento.isJsonArray()) {
                    produtos = elemento.getAsJsonArray();
                }
                reader.close();
            }

            boolean checagem = false;
            for(JsonElement produtoElem : produtos) {
                JsonObject produto = produtoElem.getAsJsonObject();
                if(produto.get("name").getAsString().equalsIgnoreCase(produtoVenda)) {
                    produto.addProperty("quantidade", produto.get("quantidade").getAsInt() - quantidadeVendida);
                    checagem = true;
                    break;
                }
            }

            FileWriter writer = new FileWriter(caminho);
            gson.toJson(produtos, writer);
            writer.close();
            System.out.println("*Produto atualizado após venda.");
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    // Método para remover produto do estoque
    public void removerProduto(String produtoExcluido) {
        String caminho = "src/main/java/com/mercadinho/data/produto.json";
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonArray produtos = new JsonArray();

        try {
            File file = new File(caminho);
            if(file.exists()) {
                FileReader reader = new FileReader(file);
                JsonElement elemento = JsonParser.parseReader(reader);
                if(elemento.isJsonArray()) {
                    produtos = elemento.getAsJsonArray();
                }
                reader.close();
            }

            Iterator<JsonElement> iterator = produtos.iterator();
            while(iterator.hasNext()) {
                JsonObject produto = iterator.next().getAsJsonObject();
                if(produto.get("name").getAsString().equalsIgnoreCase(produtoExcluido)) {
                    iterator.remove();
                    System.out.println("\n -------------------------------- \n1"
                            + "Produto removido com sucesso.");
                }
            }

            FileWriter writer = new FileWriter(caminho);
            gson.toJson(produtos, writer);
            writer.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}