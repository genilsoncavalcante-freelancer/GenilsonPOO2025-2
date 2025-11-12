package br.ufpb.genilson.exercicio1;
import java.util.Scanner;

public class TestaAluno {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Aluno[] alunos = new Aluno[3];

        for(int i = 0; i < alunos.length; i++) {
            System.out.println("\n=== Cadastro do aluno " + (i + 1) + " ===");
            System.out.println("Nome: ");
            String nome = sc.nextLine();

            System.out.println("Matrícula: ");
            String matricula = sc.nextLine();

            System.out.println("Quantas notas você possui? ");
            int qntDeNotas = sc.nextInt();

            double[] notas = new double[qntDeNotas];
            for(int j = 0; j < qntDeNotas; j++) {
                System.out.print("Nota " + (j + 1) + ": ");
                notas[j] = sc.nextDouble();
            }
            sc.nextLine();

            alunos[i] = new Aluno(nome, matricula, notas);
        }

        System.out.println("\n=== Resultados ===");
        for(Aluno a : alunos) {
            System.out.println(a);
        }
        sc.close();
    }
}
