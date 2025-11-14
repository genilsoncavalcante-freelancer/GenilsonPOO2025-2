package br.ufpb.genilson.exercicio2;

/**
 * Exceção checada que informa tentativa de adicionar produto duplicado.
 */
public class ProdutoDuplicadoException extends Exception {
    public ProdutoDuplicadoException(String message) {
        super(message);
    }
}