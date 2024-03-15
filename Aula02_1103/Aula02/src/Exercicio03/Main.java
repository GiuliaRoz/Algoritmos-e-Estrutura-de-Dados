package Exercicio03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    List<Produto> produtos;

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        produtos = new ArrayList<>();
        Scanner tec = new Scanner(System.in);

        System.out.println("Escolha uma opção: ");
        System.out.println("A - Cadastrar um Produto");
        System.out.println("B - Remover um Produto");
        System.out.println("C - Alterar um Produto");
        System.out.println("D - Exibir Lista de Produtos");
        System.out.println("E - Exibir Segmentos");
        System.out.println("F - Finalizar");
        char resposta = tec.next().toUpperCase().charAt(0);

        while (resposta != 'F') {
            switch (resposta) {
                case 'A':
                    cadastrarProduto(tec);
                    break;

                case 'B':
                    System.out.println(remover(tec));
                    break;

                case 'C':
                    alterar(tec);
                    break;

                case 'D':
                    System.out.println(listar());
                    break;

                case 'E':
                    System.out.println(listarSegmentos());
                    break;

                default:
                    System.out.println("Opção Inválida!");
                    break;
            }
            System.out.println("Escolha uma opção: ");
            System.out.println("A - Cadastrar um Produto");
            System.out.println("B - Remover um Produto");
            System.out.println("C - Alterar um Produto");
            System.out.println("D - Exibir Lista de Produtos");
            System.out.println("E - Exibir Segmentos");
            System.out.println("F - Finalizar");
            resposta = tec.next().toUpperCase().charAt(0);
        }
    }

    private void cadastrarProduto(Scanner tec) {
        System.out.println("Insira o nome do produto: ");
        String nome = tec.next();
        while (validar(nome)) {
            System.out.println("Produto já cadastrado!");
            System.out.println("Insira nome do produto:");
            nome = tec.next();
        }
        System.out.println("Insira o valor do produto: ");
        double valor = tec.nextDouble();

        System.out.println("Selecione o número do segmento: ");
        System.out.println("1 - Tecnológico");
        System.out.println("2 - Alimentício");
        System.out.println("3 - Farmácia");
        System.out.println("4 - Cosmético");
        System.out.println("5 - Higiene");
        System.out.println("6 - Vestuário");
        System.out.println("7 - Pet Shop");
        System.out.println("8 - Papelaria");
        System.out.println("9 - Casa");
        System.out.println("10 - Lazer");
        int segmento = tec.nextInt();
        while (segmento < 1 || segmento > 10) {
            System.out.println("Selecione o número de um segmento válido!");
            System.out.println("1 - Tecnológico");
            System.out.println("2 - Alimentício");
            System.out.println("3 - Farmácia");
            System.out.println("4 - Cosmético");
            System.out.println("5 - Higiene");
            System.out.println("6 - Vestuário");
            System.out.println("7 - Pet Shop");
            System.out.println("8 - Papelaria");
            System.out.println("9 - Casa");
            System.out.println("10 - Lazer");
            segmento = tec.nextInt();
        }
        Produto produto = new Produto(nome, valor, segmento);
        produtos.add(produto);
        System.out.println("Produto cadastrado com sucesso!");
    }

    private boolean validar(String nome) {
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getNome().trim().equalsIgnoreCase(nome)) {
                return true;
            }
        }
        return false;
    }

    private String remover(Scanner tec) {
        System.out.println("Insira o nome do produto que se quer remover:");
        String nome = tec.next();
        for (Produto p : produtos) {
            if (p.getNome().equalsIgnoreCase(nome)) {
                produtos.remove(p);
                return "Produto removido com sucesso!";
            }

        }
        return "Produto não encontrado!";
    }

    private void alterar(Scanner tec) {
        Produto alterado = null;
        System.out.println("Insira o produto a ser alterado: ");
        String nome = tec.next();
        while (validar(nome) == false) {
            System.out.println("Produto não encontrado!");
            System.out.println("Insira o nome do produto a ser alterado: ");
            nome = tec.next();
        }

        for (Produto p : produtos) {
            if (nome.equalsIgnoreCase(p.getNome())) {
                alterado = p;
            }
            System.out.println("Deseja alterar o nome do produto? (1-Sim/2-Não)");
            int resp1 = tec.nextInt();
            if (resp1 == 1) {
                System.out.println("Insira o novo nome do produto: ");
                String novo = tec.next();
                while (validar(novo)) {
                    System.out.println("Produto já cadastrado!");
                    System.out.println("Insira o novo nome do produto: ");
                    novo = tec.next();
                }
                alterado.setNome(novo);
            }
            System.out.println("Deseja alterar o valor do produto? (1-Sim/2-Não)");
            int resp2 = tec.nextInt();
            if (resp2 == 1) {
                System.out.println("Insira o valor do produto:");
                double valor = tec.nextDouble();
                alterado.setValor(valor);
            }
            System.out.println("Deseja alterar o segmento do produto? (1-Sim/2-Não)");
            int resp3 = tec.nextInt();
            if (resp3 == 1) {
                System.out.println("Insira o segmento do produto: ");
                System.out.println("1 - Tecnológico");
                System.out.println("2 - Alimentício");
                System.out.println("3 - Farmácia");
                System.out.println("4 - Cosmético");
                System.out.println("5 - Higiene");
                System.out.println("6 - Vestuário");
                System.out.println("7 - Pet Shop");
                System.out.println("8 - Papelaria");
                System.out.println("9 - Casa");
                System.out.println("10 - Lazer");
                int segmento = tec.nextInt();
                while (segmento < 1 || segmento > 10) {
                    System.out.println("Selecione o número de um segmento válido!");
                    System.out.println("1 - Tecnológico");
                    System.out.println("2 - Alimentício");
                    System.out.println("3 - Farmácia");
                    System.out.println("4 - Cosmético");
                    System.out.println("5 - Higiene");
                    System.out.println("6 - Vestuário");
                    System.out.println("7 - Pet Shop");
                    System.out.println("8 - Papelaria");
                    System.out.println("9 - Casa");
                    System.out.println("10 - Lazer");
                    segmento = tec.nextInt();
                }
                alterado.setSegmento(segmento);
            }

            System.out.println("Produto alterado com sucesso!");

        }
    }

    private String listar() {
        String lista = "\nPRODUTOS CADASTRADOS";
        lista += "\n-----------------------------------------------------------\n";
        lista += "SEGMENTO \t\t NOME \t\t\t VALOR\n";
        for (Produto p : produtos) {
            lista += p.toString() + "\n";
        }
        return lista;
    }

    private String listarSegmentos() {
        int qtd1 = 0, qtd2 = 0, qtd3 = 0, qtd4 = 0, qtd5 = 0, qtd6 = 0, qtd7 = 0, qtd8 = 0, qtd9 = 0, qtd10 = 0;
        String lista = "\nSEGMENTOS: ";
        lista += "\n------------------------------------------------\n";
        lista += "NOME \t\t" + "QUANTIDADE DE PRODUTOS \n";
        for (Produto p : produtos) {
            if (p.getSegmento() == 1) {
                qtd1++;
            } else if (p.getSegmento() == 2) {
                qtd2++;
            } else if (p.getSegmento() == 3) {
                qtd3++;
            } else if (p.getSegmento() == 4) {
                qtd4++;
            } else if (p.getSegmento() == 5) {
                qtd5++;
            } else if (p.getSegmento() == 6) {
                qtd6++;
            } else if (p.getSegmento() == 7) {
                qtd7++;
            } else if (p.getSegmento() == 8) {
                qtd8++;
            } else if (p.getSegmento() == 9) {
                qtd9++;
            } else {
                qtd10++;
            }
        }
        lista += "Tecnológico \t\t" + qtd1 + "\nAlimentício \t\t" + qtd2 + "\nFarmácia \t\t" + qtd3 + "\nCosmético \t\t"
                + qtd4 + "\nHigiene \t\t" + qtd5 + "\nVestuário \t\t" + qtd6 + "\nPet Shop \t\t" + qtd7
                + "\nPapelaria \t\t" + qtd8 + "\nCasa \t\t\t" + qtd9 + "\nLazer \t\t\t" + qtd10;
        return lista;
    }
}
