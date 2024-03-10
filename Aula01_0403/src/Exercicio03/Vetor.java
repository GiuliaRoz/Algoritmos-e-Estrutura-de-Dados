// Estudante: Giulia Rozza Piai

package Exercicio03;

public class Vetor {
    private Produto vetor[];

    public Vetor() {
        vetor = new Produto[0];
    }

    public Produto[] getVetor() {
        return vetor;
    }

    public void setVetor(Produto[] vetor) {
        this.vetor = vetor;
    }

    public void cadastrar(Produto prod) {
        int tamanho = vetor.length;
        tamanho++;

        Produto vetorTemporario[] = new Produto[tamanho];
        for (int i = 0; i < vetor.length; i++) {
            vetorTemporario[i] = vetor[i];
        }

        Produto umProduto = prod;
        vetorTemporario[tamanho - 1] = umProduto;
        vetor = vetorTemporario;
    }

    public void remover(String nome) {
        int tamanho = vetor.length;
        
        Produto vetorTemporario[] = new Produto[tamanho - 1];

        int removido = 0;
        for (int i = 0; i < tamanho; i++) {
            if (vetor[i].getNome().equalsIgnoreCase(nome)) {
                removido = i;
            }
        }

        for (int i = 0; i < tamanho - 1; i++) {
            if (i >= removido) {
                vetorTemporario[i] = vetor[i + 1];
            } else {
                vetorTemporario[i] = vetor[i];
            }
        }
        tamanho--;
        vetor = vetorTemporario; 

    }

    public String listar() {
        int tamanho = vetor.length;
        String lista = "\nProdutos: \n";
        for (int i = 0; i < tamanho; i++) {
                lista += vetor[i].toString() + "\n";
        }
        return lista;
    }

    public String pesquisar(String termo) {
        termo = termo.toLowerCase();
        String pesquisa = "\nO(s) produto(s) encontrado(s) foi/foram: \n";
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i].getNome().toLowerCase().contains(termo)) {
                pesquisa += vetor[i].toString() + "\n";
            }
        }
        return pesquisa;
    }

    public void alterar(String nome, String novoNome, double valor) {
        for(int i = 0; i < vetor.length; i++) {
            if (vetor[i].getNome().equalsIgnoreCase(nome)) {
                vetor[i].setNome(novoNome);
                vetor[i].setValor(valor);;
            }
        }
    }

}
