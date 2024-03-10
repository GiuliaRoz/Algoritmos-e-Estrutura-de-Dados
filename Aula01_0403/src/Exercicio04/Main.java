// Estudante: Giulia Rozza Piai
/*  A razão de escolha da estrutura Fila foi a condição especificada sobre a remoção do atendimento no enunciado, 
o fato de que a primeira pessoa a ser removida deveria ser a primeira adicionada previamente fez com que 
o uso de uma fila se adequasse ao requisito, por conta de sua característica FIFO, e facilitasse o processo */

package Exercicio04;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        Queue<Pessoa> fila = new LinkedList<>();

        Scanner tec = new Scanner(System.in);
        System.out.println("Escolha uma opção:");
        System.out.println("A - Cadastrar um atendimento");
        System.out.println("B - Iniciar um atendimento");
        System.out.println("C - Finalizar");
        char resposta = tec.next().toUpperCase().charAt(0);

        while (resposta != 'C') {
            switch (resposta) {
                case 'A':
                    System.out.println("Insira um nome para o cadastro do atendimento: ");
                    String cadastrado = tec.next();
                    System.out.println(cadastrar(cadastrado, fila));
                    break;

                case 'B':
                    System.out.println("Iniciando atendimento por ordem de chegada:");
                    System.out.println(remover(fila));
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
            System.out.println("Escolha uma opção:");
            System.out.println("A - Cadastrar um atendimento");
            System.out.println("B - Iniciar um atendimento");
            System.out.println("C - Finalizar");
            resposta = tec.next().toUpperCase().charAt(0);

        }
        tec.close();

    }

    private String cadastrar(String nome, Queue<Pessoa> fila) {
        Pessoa atendimento = new Pessoa(nome);
        fila.add(atendimento);
        return "Atendimento cadastrado com sucesso!";

    }

    private String remover(Queue<Pessoa> fila) {
        Pessoa removida = fila.remove();
        return "O cliente " + removida.getNome() + " poderá prosseguir para o seu atendimento!";
    }
}
