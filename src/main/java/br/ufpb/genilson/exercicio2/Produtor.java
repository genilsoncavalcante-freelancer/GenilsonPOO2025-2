package br.ufpb.genilson.exercicio2;

import java.util.Objects;

/**
 * Representa um produto.
 * O id é gerado automaticamente e é imutável.
 */
public class Produto {
    private static int proximoId = 1; // auto-increment simples

    private final int id;
    private String nome;
    private int estoque;
    private String dataDeFabricacao;
    private String dataDeValidade;
    private String categoria;

    // Construtor principal (não recebe id; id é atribuído automaticamente)
    public Produto(String nome, int estoque, String dataDeFabricacao, String dataDeValidade, String categoria) {
        this.id = proximoId++;
        this.nome = nome;
        this.estoque = estoque;
        this.dataDeFabricacao = dataDeFabricacao;
        this.dataDeValidade = dataDeValidade;
        this.categoria = categoria;
    }

    // Construtor padrão
    public Produto() {
        this("", 0, "", "", "");
    }

    // Getters (id não tem setter pois é imutável)
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getEstoque() {
        return estoque;
    }

    public String getDataDeFabricacao() {
        return dataDeFabricacao;
    }

    public String getDataDeValidade() {
        return dataDeValidade;
    }

    public String getCategoria() {
        return categoria;
    }

    // Setters (exceto id)
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public void setDataDeFabricacao(String dataDeFabricacao) {
        this.dataDeFabricacao = dataDeFabricacao;
    }

    public void setDataDeValidade(String dataDeValidade) {
        this.dataDeValidade = dataDeValidade;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * Atualiza o estoque somando a quantidade informada.
     * Se a operação resultar em estoque negativo, lança EstoqueInsuficienteException.
     *
     * @param quantidade quantidade a adicionar (pode ser negativa para retirada)
     * @throws EstoqueInsuficienteException se estoque ficaria negativo
     */
    public void atualizarEstoque(int quantidade) throws EstoqueInsuficienteException {
        int novoEstoque = this.estoque + quantidade;
        if (novoEstoque < 0) {
            throw new EstoqueInsuficienteException("Operação inválida: estoque insuficiente para remover " + (-quantidade) + " unidades. Estoque atual: " + this.estoque);
        }
        this.estoque = novoEstoque;
    }

    /**
     * Exemplo simples de regra de promoção.
     * Você pode ajustar a regra conforme desejar.
     * Aqui: se a categoria contém "promo" (case-insensitive) retorna true.
     *
     * @return true se estiver em promoção
     */
    public boolean estaEmPromocao() {
        if (categoria == null) return false;
        return categoria.toLowerCase().contains("promo");
    }

    @Override
    public String toString() {
        return String.format("Produto{id=%d, nome='%s', estoque=%d, fab='%s', validade='%s', categoria='%s'}",
                id, nome, estoque, dataDeFabricacao, dataDeValidade, categoria);
    }

    /**
     * Dois produtos são considerados iguais se possuírem o mesmo id.
     * Isso é coerente porque o id é único e imutável.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Produto produto = (Produto) o;
        return id == produto.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}