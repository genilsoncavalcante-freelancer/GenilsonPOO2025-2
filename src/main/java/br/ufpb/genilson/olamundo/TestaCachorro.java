package br.ufpb.genilson.olamundo;

import javax.swing.*;

public class TestaCachorro {
    public static void main(String[] args) {
        int quantCachorros = Integer.parseInt(JOptionPane.showInputDialog("São quantos cachorros: "));
        Cachorro [] listaDeCachorros = new Cachorro[quantCachorros];

        for(int n = 0; n < quantCachorros; n++) {
            String nomeCachorro = JOptionPane.showInputDialog("Digite o nome do cachorro: ");
            int idadeCachorro = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade do cachorro: "));
            String racaCachorro = JOptionPane.showInputDialog("Qual é a raça do cão? ");

            listaDeCachorros[n] = new Cachorro(nomeCachorro, idadeCachorro, racaCachorro);
        }

        System.out.println("LISTA CACHORROS LIDOS: ");

        for(Cachorro cachorro : listaDeCachorros) {
            System.out.println("NOME: " + cachorro.getNome());
            System.out.println("IDADE: " + cachorro.getIdade());
            System.out.println("RAÇA: " + cachorro.getRaca());
            System.out.println("===================");
        }
    }
}
