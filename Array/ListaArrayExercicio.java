import java.util.Scanner;

class ListaArray {
    private int[] array;
    private int tamanho;

    public ListaArray(int capacidade) {
        this.array = new int[capacidade];
        this.tamanho = 0;
    }

    public void adicionar(int elemento) {
        if (tamanho == array.length) {
            System.out.println("Erro: Lista cheia!");
            return;
        }
        array[tamanho++] = elemento;
    }

    public void remover(int posicao) {
        if (posicao < 0 || posicao >= tamanho) {
            System.out.println("Erro: Posição inválida!");
            return;
        }
        for (int i = posicao; i < tamanho - 1; i++) {
            array[i] = array[i + 1];
        }
        tamanho--;
    }

    public void imprimirLista() {
        if (tamanho == 0) {
            System.out.println("Lista vazia!");
            return;
        }
        System.out.print("Lista: ");
        for (int i = 0; i < tamanho; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}

public class TesteListaArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a capacidade da lista:");
        int capacidade = scanner.nextInt();
        ListaArray lista = new ListaArray(capacidade);

        while (true) {
            System.out.println("\nEscolha uma ação:");
            System.out.println("1 - Adicionar elemento");
            System.out.println("2 - Remover elemento");
            System.out.println("3 - Imprimir lista");
            System.out.println("4 - Sair");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o elemento a ser adicionado:");
                    int elemento = scanner.nextInt();
                    lista.adicionar(elemento);
                    break;
                case 2:
                    System.out.println("Digite a posição para remover o elemento:");
                    int posicao = scanner.nextInt();
                    lista.remover(posicao);
                    break;
                case 3:
                    lista.imprimirLista();
                    break;
                case 4:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }
}
