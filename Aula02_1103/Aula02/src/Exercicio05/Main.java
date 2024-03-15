package Exercicio05;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    HashMap<Integer, Cliente> reservas;

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        reservas = new HashMap<>();
        Scanner tec = new Scanner(System.in);

        System.out.println("Bem-vindo ao Cinema Diversão!");
        System.out.println("Filme selecionado: Todos Menos Você");
        System.out.println("\nMENU");
        System.out.println("----------------------------------------------------");
        System.out.println("A - Reservar Assento");
        System.out.println("B - Excluir Reserva de Assento");
        System.out.println("C - Alterar Reserva");
        System.out.println("D - Visualizar Assentos Disponíveis");
        System.out.println("E - Exibir Reservas");
        System.out.println("F - Consultar Valor Total de Ingressos Comprados");
        System.out.println("G - Finzalizar");
        char resposta = tec.next().toUpperCase().charAt(0);

        while (resposta != 'G') {
            switch (resposta) {
                case 'A':
                    reservarAssento(tec);
                    break;

                case 'B':
                    removerReserva(tec);
                    break;

                case 'C':
                    alterarReserva(tec);
                    break;

                case 'D':
                    System.out.println(exibirDisponiveis());
                    break;

                case 'E':
                    System.out.println(exibirReservas());
                    break;

                case 'F':
                    System.out.println(calcularTotal());
                    break;

                default: 
                System.out.println("Opção inválida!");
                break;
            }

            System.out.println("\nBem-vindo ao Cinema Diversão!");
            System.out.println("Filme selecionado: Todos Menos Você");
            System.out.println("\nMENU");
            System.out.println("----------------------------------------------------");
            System.out.println("A - Reservar Assento");
            System.out.println("B - Excluir Reserva de Assento");
            System.out.println("C - Alterar Reserva de Assento");
            System.out.println("D - Visualizar Assentos Disponíveis");
            System.out.println("E - Exibir Reservas Totais");
            System.out.println("F - Consultar Valor Total de Ingressos Comprados");
            System.out.println("G - Finzalizar");
            resposta = tec.next().toUpperCase().charAt(0);
        }

    }

    private void reservarAssento(Scanner tec) {
        System.out.println("Insira o nome do Cliente: ");
        String nome = tec.next();
        System.out.println("Insira a idade do Cliente: ");
        int idade = tec.nextInt();
        System.out.println("Selecione o número do assento dentre os disponíveis:");
        System.out.println(exibirDisponiveis());
        int numeroAssento = tec.nextInt();
        while (reservas.containsKey(numeroAssento) || numeroAssento > 20 || numeroAssento < 1) {
            System.out.println("Assento indisponível!");
            System.out.println("Selecione o número do assento de 1 a 20:");
            numeroAssento = tec.nextInt();
        }
        Cliente cliente = new Cliente(nome, idade, numeroAssento);
        if (numeroAssento >= 1 && numeroAssento <= 20) {
            reservas.put(numeroAssento, cliente);
            System.out.println("Assento reservado com sucesso!");

        }

    }

    private void removerReserva(Scanner tec) {
        System.out.println("Insira o número do assento para removê-lo:");
        int numero = tec.nextInt();
        if (reservas.containsKey(numero)) {
            reservas.remove(numero);
            System.out.println("Reserva excluída com sucesso!");
        } else {
            System.out.println("Não foi possível remover reserva!");
        }
    }

    private String exibirReservas() {
        String retorno = "\nRESERVAS DISPONÍVEIS: \n";
        int qtdReservas = 0;
        retorno += "ASSENTO \t" + "NOME \t\t" + "IDADE \t\t" + "VALOR\n";
        for (Cliente reserva : reservas.values()) {
            retorno += reserva.toString() + "\n";
            qtdReservas++;
        }
        return retorno + "\n\nTOTAL: " + qtdReservas + " reservas";
    }

    private void alterarReserva(Scanner tec) {
        System.out.println("Insira o número do assento que se deseja substituir:");
        int num = tec.nextInt();
        Cliente alterado = null;
        while (!(reservas.containsKey(num))) {
            System.out.println("Assento não identificado");
            System.out.println("Insira o número da reserva que se deseja substituir:");
            num = tec.nextInt();
        }
        for (Cliente c : reservas.values()) {
            if (num == c.getAssento()) {
                alterado = c;
            }
        }
        System.out.println("Insira o número do novo assento: ");
        int numeroAssento = tec.nextInt();
        while (reservas.containsKey(numeroAssento) || numeroAssento > 20 || numeroAssento < 1) {
            System.out.println("Assento indisponível!");
            System.out.println("Selecione o número do assento de 1 a 20:");
            numeroAssento = tec.nextInt();
        }
        alterado.setAssento(numeroAssento);
        reservas.put(numeroAssento, alterado);
        reservas.remove(num, alterado);
        System.out.println("Assento alterado com sucesso!");
    }

    private String exibirDisponiveis() {
        String assentosDisponiveis = "\nASSENTOS DISPONÍVEIS: \n";
        for (int i = 1; i < 21; i++) {
            if (!(reservas.containsKey(i))) {
                assentosDisponiveis += "| " + i + " |\t";
            }
        }
        return assentosDisponiveis;
    }

    private String calcularTotal() {
        DecimalFormat df2 = new DecimalFormat("0.00");
        double total = 0;
        for (Cliente c : reservas.values()) {
            total += c.calcularIngresso();
        }
        return "VALOR TOTAL DA COMPRA DE INGRESSOS DA SESSÃO: \n" + "R$" + df2.format(total);
    }
}
