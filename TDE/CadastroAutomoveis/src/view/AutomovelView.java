package TDE.CadastroAutomoveis.src.view;
import java.util.Scanner;
import TDE.CadastroAutomoveis.src.controller.AutomovelController;
import TDE.CadastroAutomoveis.src.model.Automovel;

public class AutomovelView {
    private Scanner scanner;
    private AutomovelController controller;

    public AutomovelView(AutomovelController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        System.out.println("Menu:");
        System.out.println("1 - Incluir automóvel");
        System.out.println("2 - Remover automóvel");
        System.out.println("3 - Alterar dados de automóvel");
        System.out.println("4 - Consultar automóvel por placa");
        System.out.println("5 - Listar automóveis (ordenado)");
        System.out.println("6 - Salvar e sair");
    }

    public int obterOpcao() {
        System.out.print("Escolha uma opção: ");
        while (!scanner.hasNextInt()) {
            System.out.print("Opção inválida. Escolha uma opção: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public void incluirAutomovel() {
        System.out.print("Digite a placa: ");
        String placa = scanner.next();
        System.out.print("Digite o modelo: ");
        String modelo = scanner.next();
        System.out.print("Digite a marca: ");
        String marca = scanner.next();
        System.out.print("Digite o ano: ");
        int ano = scanner.nextInt();
        System.out.print("Digite o valor: ");
        double valor = scanner.nextDouble();

        Automovel automovel = new Automovel(placa, modelo, marca, ano, valor);
        controller.inserirAutomovel(automovel);
    }

    public void removerAutomovel() {
        System.out.print("Digite a placa do automóvel a ser removido: ");
        String placa = scanner.next();
        controller.removerAutomovel(placa);
    }

    public void alterarAutomovel() {
        System.out.print("Digite a placa do automóvel a ser alterado: ");
        String placa = scanner.next();
        System.out.print("Digite o novo modelo: ");
        String modelo = scanner.next();
        System.out.print("Digite a nova marca: ");
        String marca = scanner.next();
        System.out.print("Digite o novo ano: ");
        int ano = scanner.nextInt();
        System.out.print("Digite o novo valor: ");
        double valor = scanner.nextDouble();

        Automovel novoAutomovel = new Automovel(placa, modelo, marca, ano, valor);
        controller.alterarAutomovel(placa, novoAutomovel);
    }

    public void consultarAutomovel() {
        System.out.print("Digite a placa do automóvel a ser consultado: ");
        String placa = scanner.next();
        Automovel automovel = controller.consultarAutomovel(placa);
        if (automovel != null) {
            System.out.println("Placa: " + automovel.getPlaca());
            System.out.println("Modelo: " + automovel.getModelo());
            System.out.println("Marca: " + automovel.getMarca());
            System.out.println("Ano: " + automovel.getAno());
            System.out.println("Valor: " + automovel.getValor());
        } else {
            System.out.println("Automóvel não encontrado.");
        }
    }

    public void listarAutomoveis() {
        System.out.println("Ordenar por:");
        System.out.println("1 - Placa");
        System.out.println("2 - Modelo");
        System.out.println("3 - Marca");
        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();

        java.util.Comparator<Automovel> comparator;
        switch (opcao) {
            case 1:
                comparator = java.util.Comparator.comparing(Automovel::getPlaca);
                break;
            case 2:
                comparator = java.util.Comparator.comparing(Automovel::getModelo);
                break;
            case 3:
                comparator = java.util.Comparator.comparing(Automovel::getMarca);
                break;
            default:
                System.out.println("Opção inválida. Ordenando por placa.");
                comparator = java.util.Comparator.comparing(Automovel::getPlaca);
        }
        var lista = controller.listarAutomoveis(comparator);
        for (Automovel automovel : lista) {
            System.out.println(
                automovel.getPlaca() + " | " +
                automovel.getModelo() + " | " +
                automovel.getMarca() + " | " +
                automovel.getAno() + " | " +
                automovel.getValor()
            );
        }
    }

    public void fechar() {
        scanner.close();
    }

    // IMPLEMENTAÇÃO DO MÉTODO showMenu
    public void showMenu() {
        boolean sair = false;
        while (!sair) {
            exibirMenu();
            int opcao = obterOpcao();
            switch (opcao) {
                case 1:
                    incluirAutomovel();
                    break;
                case 2:
                    removerAutomovel();
                    break;
                case 3:
                    alterarAutomovel();
                    break;
                case 4:
                    consultarAutomovel();
                    break;
                case 5:
                    listarAutomoveis();
                    break;
                case 6:
                    sair = true;
                    System.out.println("Salvando e saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
            System.out.println();
        }
        fechar();
    }
}