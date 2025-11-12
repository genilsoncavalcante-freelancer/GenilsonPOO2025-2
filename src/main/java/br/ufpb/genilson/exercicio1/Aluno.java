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

    public String getNome(String nome) {
        return this.nome;
    }

    public String getMatricula(String matricula) {
        return matricula;
    }

    public double getMedia(double[] notas) {
        double media = 0;

        for(int n = 0; n < notas.length; n++) {
            media += notas[n];
        }
        media = media / notas.length;
        return media;
    }

    @Override
    public String toString() {
        return "O aluno " + this.nome + " de matrícula " + this.matricula + " tem média: " + getMedia(notas);
    }

}
