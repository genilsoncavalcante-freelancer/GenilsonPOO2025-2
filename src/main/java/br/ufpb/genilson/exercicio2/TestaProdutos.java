package br.ufpb.genilson.exercicio2;

import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Programa principal para testar o SistemaGerenciadorDeProdutos.
 *
 * Lê 3 produtos do console e tenta adicioná-los ao sistema.
 * Demonstra tratamento de exceções.
 */
public class TestaProdutos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SistemaGerenciadorDeProdutos sistema = new SistemaGerenciadorDeProdutos();

        System.out.println("=== Cadastro de produtos ===");
        System.out.println("Quantos produtos deseja cadastrar? ");
        int qtdDeProdutos = sc.nextInt();
        sc.nextLine(); // <-- CORREÇÃO IMPORTANTE

        int produtosParaCadastrar = qtdDeProdutos;
        for (int i = 0; i < produtosParaCadastrar; i++) {
            System.out.println("\nProduto " + (i + 1) + ":");
            try {
                System.out.print("Nome: ");
                String nome = sc.nextLine().trim();

                System.out.print("Estoque (inteiro): ");
                int estoque = lerIntComRetry(sc);

                System.out.print("Data de fabricação (texto): ");
                String fab = sc.nextLine().trim();

                System.out.print("Data de validade (texto): ");
                String validade = sc.nextLine().trim();

                System.out.print("Categoria (ex: alimentos, eletro, promo): ");
                String categoria = sc.nextLine().trim();

                Produto prod = new Produto(nome, estoque, fab, validade, categoria);

                // tenta adicionar, se duplicado, captura a exceção
                try {
                    sistema.adicionarProduto(prod);
                    System.out.println("Produto adicionado: " + prod);
                } catch (ProdutoDuplicadoException e) {
                    System.out.println("Erro ao adicionar produto: " + e.getMessage());
                    // aqui poderíamos pedir nova entrada; para simplicidade, continuar
                }

            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida: " + e.getMessage());
                sc.nextLine(); // limpar buffer
            } catch (Exception e) {
                System.out.println("Erro inesperado: " + e.getMessage());
            }
        }

        // Mostra lista atual
        System.out.println("\n=== Produtos cadastrados ===");
        List<Produto> todos = sistema.listarTodos();
        if (todos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
        } else {
            todos.forEach(System.out::println);
        }

        // Testa atualização de estoque (exemplo de uso e captura de exceção)
        if (!todos.isEmpty()) {
            Produto primeiro = todos.get(0);
            System.out.println("\nTestando atualização de estoque no produto id " + primeiro.getId());
            try {
                System.out.println("Estoque atual: " + primeiro.getEstoque());
                System.out.println("Tentando remover 5 unidades...");
                sistema.atualizarEstoque(primeiro.getId(), -5); // tentativa de retirada
                System.out.println("Novo estoque: " + primeiro.getEstoque());
            } catch (EstoqueInsuficienteException | NoSuchElementException e) {
                System.out.println("Erro ao atualizar estoque: " + e.getMessage());
            }
        }

        // Demonstra remoção (opcional)
        if (!todos.isEmpty()) {
            int idARemover = todos.get(0).getId();
            System.out.println("\nRemovendo produto id " + idARemover);
            boolean removido = sistema.removerProdutoPorId(idARemover);
            System.out.println("Removido? " + removido);
            System.out.println("Lista atualizada:");
            sistema.listarTodos().forEach(System.out::println);
        }

        sc.close();
    }

    /**
     * Lê um inteiro do Scanner com tentativa até receber um inteiro válido.
     */
    private static int lerIntComRetry(Scanner sc) {
        while (true) {
            try {
                String linha = sc.nextLine().trim();
                return Integer.parseInt(linha);
            } catch (NumberFormatException e) {
                System.out.print("Valor inválido. Digite um número inteiro: ");
            }
        }
    }
}