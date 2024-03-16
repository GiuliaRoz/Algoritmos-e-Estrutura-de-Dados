package Exercicio05;

public class Cliente {
    private String nome;
    private int idade;
    private int assento;


    public Cliente(String nome, int idade, int assento) {
        setNome(nome);
        setIdade(idade);
        setAssento(assento);
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

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        if (idade <= 0) {
            throw new IllegalArgumentException("Idade não pode ser negativa!");
        }
        this.idade = idade;
    }

    public int getAssento() {
        return assento;
    }

    public void setAssento(int assento) {
        this.assento = assento;
    }

    public double calcularIngresso() {
        double valorIngresso = 0;
        if (getIdade() <= 18) {
            valorIngresso = 12.50;
        } else {
            valorIngresso = 25;
        }
        return valorIngresso;
    }

    public String toString() {
        return  getAssento() + "\t\t" + getNome() + "\t\t" + getIdade() + "\t\t" + calcularIngresso();
    }
}
