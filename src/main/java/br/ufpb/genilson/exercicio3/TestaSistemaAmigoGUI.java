package br.ufpb.genilson.exercicio3;

import java.util.Scanner;

public class TestaSistemaAmigoGUI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SistemaAmigo sistema = new SistemaAmigo();

        System.out.println("Quantidade de amigos: ");
        int qtd = sc.nextInt();
        sc.nextLine();

        // cadastrar amigos
        for (int i = 0; i < qtd; i++) {
            System.out.print("Nome: ");
            String nome = sc.nextLine();
            System.out.print("Email: ");
            String email = sc.nextLine();
            sistema.cadastraAmigo(nome, email);
        }

        // sorteio manual
        for (int i = 0; i < qtd; i++) {
            System.out.println("Email da pessoa: ");
            String p = sc.nextLine();
            System.out.println("Email do amigo secreto sorteado: ");
            String s = sc.nextLine();

            try {
                sistema.configuraAmigoSecretoDe(p, s);
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }

        // envio de mensagem
        System.out.println("Remetente: ");
        String rem = sc.nextLine();
        System.out.println("Texto da mensagem: ");
        String txt = sc.nextLine();
        System.out.println("É anônima? (true/false): ");
        boolean anon = sc.nextBoolean();

        sistema.enviarMensagemParaTodos(txt, rem, anon);

        System.out.println("Mensagem enviada!");
        sc.close();
    }
}
