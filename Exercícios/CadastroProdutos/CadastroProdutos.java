import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class CadastroProdutos {
    private List<Produto> produtos;

    public CadastroProdutos() {
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
        System.out.println("Produto adicionado: " + produto);
    }

    public void removerProduto(int codigo) {
        Produto produto = buscarProdutoPorCodigo(codigo);
        if (produto != null) {
            produtos.remove(produto);
            System.out.println("Produto removido: " + produto);
        } else {
            System.out.println("Erro: Produto não encontrado!");
        }
    }

    public Produto buscarProdutoPorCodigo(int codigo) {
        for (Produto produto : produtos) {
            if (produto.getCodigo() == codigo) {
                return produto;
            }
        }
        return null;
    }

    public Produto buscarProdutoPorNome(String nome) {
        for (Produto produto : produtos) {
            if (produto.getNome().equalsIgnoreCase(nome)) {
                return produto;
            }
        }
        return null;
    }

    public void imprimirProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
        } else {
            for (Produto produto : produtos) {
                System.out.println(produto);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CadastroProdutos cadastro = new CadastroProdutos();

        while (true) {
            System.out.println("1. Adicionar produto");
            System.out.println("2. Remover produto");
            System.out.println("3. Buscar produto por código");
            System.out.println("4. Buscar produto por nome");
            System.out.println("5. Imprimir todos os produtos");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    int codigo;
                    while (true) {
                        System.out.print("Digite o código do produto: ");
                        try {
                            codigo = scanner.nextInt();
                            scanner.nextLine(); // Consumir a nova linha
                            break;
                        } catch (java.util.InputMismatchException e) {
                            System.out.println("Por favor, digite um número válido para o código do produto!");
                            scanner.nextLine(); // Limpar entrada inválida
                        }
                    }
                    System.out.print("Digite o nome do produto: ");
                    String nome = scanner.nextLine();
                    int quantidade;
                    while (true) {
                        System.out.print("Digite a quantidade do produto: ");
                        try {
                            quantidade = scanner.nextInt();
                            scanner.nextLine(); // Consumir a nova linha
                            break;
                        } catch (java.util.InputMismatchException e) {
                            System.out.println("Por favor, digite um número válido para a quantidade!");
                            scanner.nextLine();
                        }
                    }
                    Produto produto = new Produto(codigo, nome, quantidade);
                    cadastro.adicionarProduto(produto);
                    break;
                case 2:
                    int codigoRemover;
                    while (true) {
                        System.out.print("Digite o código do produto a ser removido: ");
                        try {
                            codigoRemover = scanner.nextInt();
                            scanner.nextLine();
                            break;
                        } catch (java.util.InputMismatchException e) {
                            System.out.println("Por favor, digite um número válido para o código!");
                            scanner.nextLine();
                        }
                    }
                    cadastro.removerProduto(codigoRemover);
                    break;
                case 3:
                    int codigoBuscar;
                    while (true) {
                        System.out.print("Digite o código do produto: ");
                        try {
                            codigoBuscar = scanner.nextInt();
                            scanner.nextLine();
                            break;
                        } catch (java.util.InputMismatchException e) {
                            System.out.println("Por favor, digite um número válido para o código!");
                            scanner.nextLine();
                        }
                    }
                    Produto produtoBuscado = cadastro.buscarProdutoPorCodigo(codigoBuscar);
                    if (produtoBuscado != null) {
                        System.out.println(produtoBuscado);
                    } else {
                        System.out.println("Produto não encontrado!");
                    }
                    break;
                case 4:
                    System.out.print("Digite o nome do produto: ");
                    String nomeBuscar = scanner.nextLine();
                    Produto produtoBuscadoNome = cadastro.buscarProdutoPorNome(nomeBuscar);
                    if (produtoBuscadoNome != null) {
                        System.out.println(produtoBuscadoNome);
                    } else {
                        System.out.println("Produto não encontrado!");
                    }
                    break;
                case 5:
                    cadastro.imprimirProdutos();
                    break;
                case 6:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
