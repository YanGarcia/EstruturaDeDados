import java.util.Scanner;

public class OrdenacaoProdutos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Arrays para armazenar os nomes e preços dos produtos
        String[] nomes = new String[10];
        double[] precos = new double[10];

        // Entrada de dados
        for (int i = 0; i < 10; i++) {
            System.out.println("Digite o nome do produto " + (i + 1) + ":");
            nomes[i] = scanner.nextLine();
            System.out.println("Digite o preço do produto " + (i + 1) + ":");
            precos[i] = scanner.nextDouble();
            scanner.nextLine(); // Consumir a quebra de linha
        }

        // Ordenação usando o algoritmo Bubble Sort
        for (int i = 0; i < precos.length - 1; i++) {
            for (int j = 0; j < precos.length - 1 - i; j++) {
                if (precos[j] < precos[j + 1]) {
                    // Trocar os preços
                    double tempPreco = precos[j];
                    precos[j] = precos[j + 1];
                    precos[j + 1] = tempPreco;

                    // Trocar os nomes correspondentes
                    String tempNome = nomes[j];
                    nomes[j] = nomes[j + 1];
                    nomes[j + 1] = tempNome;
                }
            }
        }

        // Exibir os produtos ordenados
        System.out.println("\nProdutos ordenados do mais caro para o mais barato:");
        for (int i = 0; i < 10; i++) {
            System.out.println("Produto: " + nomes[i] + " - Preço: R$ " + precos[i]);
        }

        scanner.close();
    }
}