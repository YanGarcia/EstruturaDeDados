import java.util.Scanner;

class ListaArrayString {
    private String[] array;
    private int tamanho;

    public ListaArrayString(int capacidade) {
        this.array = new String[capacidade];
        this.tamanho = 0;
    }

    public void adicionar(String elemento) {
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
        System.out.print("Lista de Nomes: ");
        for (int i = 0; i < tamanho; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}

public class TesteListaArrayString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a capacidade da lista:");
        int capacidade = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha
        ListaArrayString lista = new ListaArrayString(capacidade);

        while (true) {
            System.out.println("\nEscolha uma ação:");
            System.out.println("1 - Adicionar nome");
            System.out.println("2 - Remover nome");
            System.out.println("3 - Imprimir lista");
            System.out.println("4 - Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome a ser adicionado:");
                    String nome = scanner.nextLine();
                    lista.adicionar(nome);
                    break;
                case 2:
                    System.out.println("Digite a posição para remover o nome:");
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
