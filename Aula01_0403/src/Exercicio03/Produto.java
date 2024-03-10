// Estudante: Giulia Rozza Piai

package Exercicio03;

import java.text.DecimalFormat;

public class Produto {
    private String nome;
    private double valor;

    public Produto(String nome, double valor) {
        setNome(nome);
        setValor(valor);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null||nome.isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser um campo vazio!");
        }
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor não pode ser zerado ou negativo!");
        }
        this.valor = valor;
    }

    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        return "Nome: " + getNome() + "\tValor: R$" + df.format(getValor());
    }
}
