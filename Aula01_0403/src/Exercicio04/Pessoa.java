// Estudante: Giulia Rozza Piai

package Exercicio04;

public class Pessoa {
    String nome;

    public Pessoa(String nome) {
        setNome(nome);
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

}
