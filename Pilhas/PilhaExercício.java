import java.util.Scanner;

class Pilha {
    private int topo;
    private int[] elementos;
    private int capacidade;

    public Pilha(int capacidade) {
        this.capacidade = capacidade;
        this.elementos = new int[capacidade];
        this.topo = -1; // Indica pilha vazia
    }

    public boolean isEmpty() {
        return topo == -1;
    }

    public boolean isFull() {
        return topo == capacidade - 1;
    }

    public void push(int elemento) {
        if (isFull()) {
            System.out.println("Erro: Pilha cheia!");
            return;
        }
        elementos[++topo] = elemento;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Erro: Pilha vazia!");
            return -1;
        }
        return elementos[topo--];
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Erro: Pilha vazia!");
            return -1;
        }
        return elementos[topo];
    }

    public void imprimirPilha() {
        if (isEmpty()) {
            System.out.println("Pilha vazia!");
            return;
        }
        System.out.print("Pilha: ");
        for (int i = 0; i <= topo; i++) {
            System.out.print(elementos[i] + " ");
        }
        System.out.println();
    }
}

public class TestePilha {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a capacidade da pilha:");
        int capacidade = scanner.nextInt();
        Pilha pilha = new Pilha(capacidade);

        while (true) {
            System.out.println("\nEscolha uma ação:");
            System.out.println("1 - Empilhar elemento");
            System.out.println("2 - Desempilhar elemento");
            System.out.println("3 - Ver topo da pilha");
            System.out.println("4 - Imprimir pilha");
            System.out.println("5 - Sair");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o elemento a ser empilhado:");
                    int elemento = scanner.nextInt();
                    pilha.push(elemento);
                    break;
                case 2:
                    System.out.println("Elemento desempilhado: " + pilha.pop());
                    break;
                case 3:
                    System.out.println("Topo da pilha: " + pilha.peek());
                    break;
                case 4:
                    pilha.imprimirPilha();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }
}
