import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    Queue<String> tarefas;

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        tarefas = new LinkedList<>();
        Scanner tec = new Scanner(System.in);

        System.out.println("Escolha uma opção: ");
        System.out.println("A - Adicionar Tarefa");
        System.out.println("B - Remover Tarefa Concluída");
        System.out.println("C - Visualizar Próxima Tarefa");
        System.out.println("D - Sair");
        char resposta = tec.next().toUpperCase().charAt(0);
        while (resposta != 'D') {
            switch (resposta) {
                case 'A':
                    adicionar(tec);
                    break;

                case 'B':
                    System.out.println(remover());
                    break;

                case 'C':
                    System.out.println(visualizar());
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
            System.out.println("Escolha uma opção: ");
            System.out.println("A - Adicionar Tarefa");
            System.out.println("B - Remover Tarefa Concluída");
            System.out.println("C - Visualizar Próxima Tarefa");
            System.out.println("D - Sair");
            resposta = tec.next().trim().toUpperCase().charAt(0);
        }
        tec.close();
    }

    private void adicionar(Scanner tec) {
        System.out.println("Insira uma Tarefa: ");
        String tarefa = tec.next().trim().toUpperCase();

        while (tarefas.contains(tarefa) || tarefa == null) {
            System.out.println("Tarefa já incluída!");
            System.out.println("Insira uma Tarefa: ");
            tarefa = tec.next().toUpperCase();
        }
        tarefas.add(tarefa);
        System.out.println("Tarefa adicionada com sucesso!");
    }

    private String remover() {
        if (tarefas.isEmpty()) {
            return "Não há tarefas para remover!";
        }
        String tarefa = tarefas.peek();
        tarefas.remove();
        return "Tarefa '" + tarefa + "' concluída com sucesso!";
    }

    private String visualizar() {
        if (tarefas.isEmpty()) {
            return "Não há tarefas pendentes!";
        }
        String tarefa = tarefas.peek();
        return "PRÓXIMA TAREFA: " + tarefa;

    }
}
