package Exercicio02;

import java.util.Scanner;
import java.util.Vector;

public class Main {
    Vector<String> vector;

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        vector = new Vector<>();
        Scanner tec = new Scanner(System.in);

        System.out.println("Escolha uma opção: ");
        System.out.println("A - Cadastrar um nome");
        System.out.println("B - Remover um nome");
        System.out.println("C - Alterar um nome");
        System.out.println("D - Pesquisar termo");
        System.out.println("E - Listar nomes");
        System.out.println("F - Finalizar");
        char resposta = tec.next().toUpperCase().charAt(0);

        while (resposta != 'F') {
            switch (resposta) {
                case 'A':
                    System.out.println("Insira um nome: ");
                    String cadastrado = tec.next();
                    System.out.println(cadastrar(cadastrado));
                    break;

                case 'B':
                    System.out.println("Insira o nome a ser removido: ");
                    String removido = tec.next();
                    System.out.println(remover(removido));
                    break;

                case 'C':
                    System.out.println("Insira o nome que se deseja alterar: ");
                    String alterado = tec.next();
                    System.out.println(alterar(alterado, tec));
                    break;

                case 'D':
                    System.out.println("Insira um termo a ser pesquisado: ");
                    String termo = tec.next();
                    System.out.println(pesquisar(termo));
                    break;

                case 'E':
                    System.out.println(selecionar());
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
            System.out.println("Escolha uma opção: ");
            System.out.println("A - Cadastrar um nome");
            System.out.println("B - Remover um nome");
            System.out.println("C - Alterar um nome");
            System.out.println("D - Pesquisar termo");
            System.out.println("E - Listar nomes");
            System.out.println("F - Finalizar");
            resposta = tec.next().toUpperCase().charAt(0);
        }
        tec.close();
    }

    private String cadastrar(String nome) {
        nome = nome.toUpperCase();
        if (nome != null && !(vector.contains(nome))) {
            vector.add(nome);
            return "Nome cadastrado com sucesso!";
        }
        return "Não foi possível cadastrar, nome já inserido!";
    }

    private String remover(String nome) {
        nome = nome.toUpperCase();
        if (nome != null && vector.contains(nome)) {
            vector.remove(nome);
            return "Nome removido com sucesso!";
        }
        return "Não foi possível remover o nome selecionado!";
    }

    private String selecionar() {
        String imprimir = "LISTA DE NOMES: \n";
        for (String s : vector) {
            imprimir += s + "\n";
        }
        return imprimir;
    }

    private String alterar(String alterado, Scanner tec) {

        alterado = alterado.toUpperCase();
        String antigo = alterado;
        int posicao = 0;

        if (!(vector.contains(alterado))) {
            return "Nome não encontrado";
        }

        System.out.println("Insira o novo nome:");
        String novo = tec.next().toUpperCase();

        if (novo != null && !(vector.contains(novo))) {
            for (int i = 0; i < vector.size(); i++) {
                if (vector.get(i).equalsIgnoreCase(alterado)) {
                    posicao = i;
                }
            }
            alterado = novo;
            vector.set(posicao, alterado);
            return "Nome '" + antigo + "' substituído por '" + novo + "'";
        }
        return "Não foi possível substituir '" + antigo + "' por '" + novo + "'";
    }

    private String pesquisar(String termo) {
        termo = termo.trim().toUpperCase();
        String imprimir = "NOMES COM O TERMO '" + termo + "':\n";

        for (int i = 0; i < vector.size(); i++) {
            if (vector.get(i).contains(termo)) {
                imprimir += vector.get(i) + "\n";
            }
        }
        return imprimir;
    }
}
