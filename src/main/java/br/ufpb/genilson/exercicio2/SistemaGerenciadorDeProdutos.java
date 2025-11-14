package br.ufpb.genilson.exercicio2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Classe que gerencia a coleção de produtos.
 */
public class SistemaGerenciadorDeProdutos {
    private final List<Produto> produtos = new ArrayList<>();

    public SistemaGerenciadorDeProdutos() {
    }

    /**
     * Adiciona um produto ao sistema.
     * Lança ProdutoDuplicadoException se um produto com mesmo id já estiver cadastrado.
     *
     * @param produto produto a adicionar
     * @throws ProdutoDuplicadoException se produto com mesmo id já existir
     */
    public void adicionarProduto(Produto produto) throws ProdutoDuplicadoException {
        if (produto == null) throw new IllegalArgumentException("Produto não pode ser nulo");
        // Verifica se já existe produto com mesmo id
        if (produtos.contains(produto)) {
            throw new ProdutoDuplicadoException("Produto com id " + produto.getId() + " já cadastrado.");
        }
        produtos.add(produto);
    }

    /**
     * Remove o produto com o id informado.
     * Retorna true se removido, false se não encontrado.
     */
    public boolean removerProdutoPorId(int id) {
        return produtos.removeIf(p -> p.getId() == id);
    }

    /**
     * Busca produto por id.
     *
     * @return produto se encontrado; null se não encontrado
     */
    public Produto buscarPorId(int id) {
        for (Produto p : produtos) {
            if (p.getId() == id) return p;
        }
        return null;
    }

    /**
     * Lista todos os produtos (retorna cópia imutável da lista).
     */
    public List<Produto> listarTodos() {
        return Collections.unmodifiableList(new ArrayList<>(produtos));
    }

    /**
     * Atualiza o estoque do produto identificado por id somando "quantidade".
     * Lança NoSuchElementException se produto não existir.
     * Lança EstoqueInsuficienteException se a operação deixaria estoque negativo.
     */
    public void atualizarEstoque(int id, int quantidade) throws EstoqueInsuficienteException {
        Produto p = buscarPorId(id);
        if (p == null) {
            throw new NoSuchElementException("Produto com id " + id + " não encontrado.");
        }
        p.atualizarEstoque(quantidade);
    }

    /**
     * Busca produtos por categoria (simples filtro).
     */
    public List<Produto> buscarPorCategoria(String categoria) {
        List<Produto> resultado = new ArrayList<>();
        if (categoria == null) return resultado;
        for (Produto p : produtos) {
            if (categoria.equalsIgnoreCase(p.getCategoria())) {
                resultado.add(p);
            }
        }
        return resultado;
    }
}