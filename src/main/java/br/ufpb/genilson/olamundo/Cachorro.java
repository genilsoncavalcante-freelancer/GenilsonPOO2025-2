package br.ufpb.genilson.olamundo;

public class Cachorro {
    private String nome;
    private int idade;
    private String raca;

    public Cachorro(String nome, int idade, String raca) {
        this.nome = nome;
        this.idade = idade;
        this.raca = raca;
    }

    public Cachorro() {
        this("Cão", 0, "Vira lata");
    }

    public String getNome() {
        return this.nome;
    }

    public int getIdade() {
        return this.idade;
    }

    public String getRaca() {
        return this.raca;
    }

    public String toString() {
        return "O " + this.nome + " é um cachorro de raça " + this.raca + " com " + this.idade +" anos.";
    }
}
