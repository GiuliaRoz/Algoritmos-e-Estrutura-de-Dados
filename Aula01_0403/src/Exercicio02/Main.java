// Estudante: Giulia Rozza Piai

package Exercicio02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Vetor nomes = new Vetor(10);
        Scanner tec = new Scanner(System.in);

        System.out.println("Escolha uma opção:");
        System.out.println("A - Cadastrar um nome");
        System.out.println("B - Remover um nome");
        System.out.println("C - Alterar um nome");
        System.out.println("D - Listar nomes");
        System.out.println("E - Finalizar");
        char resposta = tec.next().toUpperCase().charAt(0);

        while (resposta != 'E') {
            switch (resposta) {
                case 'A':
                    System.out.println("Insira o nome a ser cadastrado:");
                    String adicionado = tec.next();
                    nomes.cadastrar(adicionado);
                    break;

                case 'B':
                    System.out.println("Insira o nome a ser removido: ");
                    String removido = tec.next();
                    nomes.remover(removido);
                    break;

                case 'C':
                System.out.println("Insira o nome que se deseja incluir:");
                String alterar = tec.next();
                System.out.println("Insira a posição que se deseja substituir:");
                int posicao = tec.nextInt();
                nomes.alterar(alterar, posicao);
                break;


                case 'D':
                System.out.println(nomes.listar());
                break;

                default:
                System.out.println("Opção inválida!");
                break;

            }
            System.out.println("Escolha uma opção:");
            System.out.println("A - Cadastrar um nome");
            System.out.println("B - Remover um nome");
            System.out.println("C - Alterar um nome");
            System.out.println("D - Listar nomes");
            System.out.println("E - Finalizar");
            resposta = tec.next().toUpperCase().charAt(0);
        }
        tec.close();
    }
}
