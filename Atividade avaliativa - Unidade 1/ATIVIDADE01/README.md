## Escolha da Estrutura Queue
<br/>
A escolha desta estrutura se deu pelos seguintes motivos:
<br/>
-         Possui grande eficiência nos métodos de adicionar e remover, que foi um dos requisistos determinados na questão. Considerando que o usuário siga a ordem de inserção de tarefas para reazlizá-las, a primeira tarefa adicionada deverá ser a primeira concluída (removida), deste modo, o princípio "First in - First Out" se adequa ao enunciado proposto, em que, o método 'remove()' retira com eficiência a primeira tarefa da Fila;
<br/>
-         A visualização da tarefa seguinte deveria ser sem necessidade de percorrer toda a estrutura, portanto, através do método 'peek()', é possível acessar somente o primeiro elemento da Fila de forma eficiente e adequada de acordo com os requisitos estabelecidos no enunciado;
<br/>
-         É uma estrutura que permite a inserção de grande quantidade de dados, sendo performática e escalável;
<br/>
<br/>
Observação complementar: poderia também utilizar-se da Lista LinkedList, permitindo que o usuário escolhesse qual a ordem de conclusão das tarefas através do nome.
<br/>
Exemplo dos métodos solicitados com LinkedList:

        private void adicionar(Scanner tec) {
        System.out.println("Insira uma Tarefa: ");
        String tarefa = tec.next().trim().toUpperCase();

        while (tarefas.contains(tarefa) || tarefa == null) {
            System.out.println("Tarefa já incluída!");
            System.out.println("Insira uma Tarefa: ");
            tarefa = tec.next().trim().toUpperCase();
        }

        tarefas.add(tarefa);
        System.out.println("Tarefa adicionada com sucesso!");
        }

        private void remover(Scanner tec) {
        System.out.println("Insira o nome da Tarefa Concluída:");
        String tarefa = tec.next().trim().toUpperCase();

        while (!(tarefas.contains(tarefa))) {
            System.out.println("Tarefa não encontrada!");
            System.out.println("Insira o nome da Tarefa Concluída:");
            tarefa = tec.next().trim().toUpperCase();
        }
        tarefas.remove(tarefa);
        System.out.println("Tarefa concluída com sucesso!");
        }

        private String visualizar() {
        if (tarefas.isEmpty()) {
            return "Não há tarefas pendentes!";
        }
        String tarefa = tarefas.getFirst();
        return "PRÓXIMA TAREFA DA LISTA: " + tarefa;
       }
<br/>
Giulia Rozza Piai
