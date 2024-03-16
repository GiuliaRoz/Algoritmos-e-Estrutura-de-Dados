package Exercicio03;

import java.text.DecimalFormat;

public class Produto {
    private String nome;
    private double valor;
    private int segmento;

    public Produto(String nome, double valor, int segmento) {
        setNome(nome);
        setValor(valor);
        setSegmento(segmento);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser um campo vazio!");
        }
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        if (valor < 0) {
            throw new IllegalArgumentException("Valor não pode ser um campo negativo!");
        }
        this.valor = valor;
    }

    public int getSegmento() {
        return segmento;
    }

    public void setSegmento(int segmento) {
        if (segmento < 0) {
            throw new IllegalArgumentException("Segmento não pode ser um campo negativo!");
        }
        this.segmento = segmento;
    }

    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        return getSegmento()+  "\t\t\t " + getNome() + "\t\t\t " + df.format(getValor());
    }
}
