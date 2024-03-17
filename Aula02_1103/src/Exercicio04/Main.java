package Exercicio04;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    List<String> nomes;

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        nomes = new LinkedList<>();
        Scanner tec = new Scanner(System.in);

        System.out.println("Escolha uma opção: ");
        System.out.println("A - Cadastrar um nome");
        System.out.println("B - Listar nomes");
        System.out.println("C - Finalizar");
        char resposta = tec.next().toUpperCase().charAt(0);

        while (resposta != 'C') {
            switch (resposta) {
                case 'A':
                    System.out.println("Insira um nome para cadastrá-lo: ");
                    String nome = tec.next().trim().toLowerCase();
                    System.out.println(cadastrar(nome));
                    break;

                case 'B':
                    System.out.println(listar());
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
            System.out.println("Escolha uma opção: ");
            System.out.println("A - Cadastrar um nome");
            System.out.println("B - Listar nomes");
            System.out.println("C - Finalizar");
            resposta = tec.next().toUpperCase().charAt(0);

        }
        tec.close();
    }

    private String cadastrar(String nome) {
        if (nome != null && !(nomes.contains(nome))) {
            nomes.add(nome);
            return "Nome adicionado com sucesso!";
        }
        return "Nome não pôde ser adiconado!";
    }

    private String listar() {
        String lista = "\nNOMES:\n";
        for (String s : nomes) {
            lista += s + "\n";
        }
        return lista;
    }
}
