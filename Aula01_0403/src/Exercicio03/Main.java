// Estudante: Giulia Rozza Piai

package Exercicio03;

import java.util.Scanner;

public class Main {
    Vetor produtos;

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        produtos = new Vetor();

        Scanner tec = new Scanner(System.in);
        System.out.println("Escolha uma opção:");
        System.out.println("A - Cadastrar um produto");
        System.out.println("B - Remover um produto");
        System.out.println("C - Pesquisar um produto");
        System.out.println("D - Alterar um produto");
        System.out.println("E - Listar produtos");
        System.out.println("F - Finalizar");
        char resposta = tec.next().toUpperCase().charAt(0);

        while (resposta != 'F') {
            switch (resposta) {
                case 'A':
                    System.out.println("Insira o nome do produto:");
                    String nome = tec.next();
                    System.out.println("Insira o valor do produto:");
                    double valor = tec.nextDouble();
                    Produto produto = new Produto(nome, valor);
                    produtos.cadastrar(produto);
                    break;

                case 'B':
                    System.out.println("Insira o nome do produto a ser removido: ");
                    String removido = tec.next();
                    produtos.remover(removido);
                    break;

                case 'C':
                    System.out.println("Insira o nome do produto a ser pesquisado:");
                    String pesquisado = tec.next();
                    System.out.println(produtos.pesquisar(pesquisado));
                    break;

                case 'D':
                    System.out.println("Insira o nome do produto que se deseja alterar:");
                    String alterado = tec.next();
                    System.out.println("Insira o novo nome do produto:");
                    String novoProduto = tec.next();
                    System.out.println("Insira o preço do produto:");
                    double preco = tec.nextDouble();
                    produtos.alterar(alterado, novoProduto, preco);
                    break;

                case 'E':
                    System.out.println(produtos.listar());
                    break;


                default:
                    System.out.println("Opção inválida!");
                    break;

            }
            System.out.println("Escolha uma opção:");
            System.out.println("A - Cadastrar um produto");
            System.out.println("B - Remover um produto");
            System.out.println("C - Pesquisar um produto");
            System.out.println("D - Alterar um produto");
            System.out.println("E - Listar produtos");
            System.out.println("F - Finalizar");
            resposta = tec.next().toUpperCase().charAt(0);
        }
        tec.close();
    }
}
