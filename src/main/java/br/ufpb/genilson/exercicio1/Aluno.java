package br.ufpb.genilson.exercicio1;

public class Aluno {
    String nome;
    String matricula;
    double[] notas;

    public Aluno(String nome, String matricula, double[] notas) {
        this.nome = nome;
        this.matricula = matricula;
        this.notas = notas;
    }

    public Aluno() {
        this("", "", new double[0]);
    }

    public String getNome() {
        return this.nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public double getMedia() {
        if (notas == null || notas.length == 0) return 0;

        double soma = 0;

        for(double n : notas) {
            soma += n;
        }

        return soma / notas.length;
    }

    @Override
    public String toString() {
        return "O aluno " + this.nome + " de matrícula " + this.matricula + " tem média: " + String.format("%.2f", getMedia());
    }

}
