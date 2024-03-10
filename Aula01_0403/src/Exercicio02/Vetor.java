// Estudante: Giulia Rozza Piai

package Exercicio02;

public class Vetor {
    private int indice;
    private String vetor[];

    public Vetor(int tamanho) {
        setIndice(0);
        vetor = new String[tamanho];
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public void cadastrar(String nome) {
        if (getIndice() < vetor.length) {
            vetor[indice] = nome;
        }
        indice++;

    }

    public void remover(String nome) {
        for (int i = 0; i < getIndice(); i++) {
            if (vetor[i] != null && vetor[i].equalsIgnoreCase(nome)) {
                for (int j = i; j < (getIndice() - 1); j++) {
                    vetor[j] = vetor[j + 1];
                }  
            }
        }
        indice--;
    }

    public void alterar(String nome, int posicao) {
        for (int i = 0; i < getIndice(); i++) {
            if (vetor[i] != null && i == posicao) {
                vetor[i] = nome;
            }
        }
    }

    public String listar() {
        String lista = "\nElementos do Array: " + "\n";
        for (int i = 0; i < getIndice(); i++) {
            if (vetor[i] != null)
                lista += i + ". " + vetor[i] + "\n";
        }
        return lista;
    }
}
