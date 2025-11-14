package br.ufpb.genilson.exercicio2;

/**
 * Exceção checada lançada quando não há estoque suficiente.
 */
public class EstoqueInsuficienteException extends Exception {
    public EstoqueInsuficienteException(String message) {
        super(message);
    }
}