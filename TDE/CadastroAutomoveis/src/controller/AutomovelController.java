package TDE.CadastroAutomoveis.src.controller;

import TDE.CadastroAutomoveis.src.model.Automovel;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AutomovelController {
    private List<Automovel> automoveis;

    public AutomovelController() {
        this.automoveis = new ArrayList<>();
    }

    public void inserirAutomovel(Automovel automovel) {
        if (consultarAutomovel(automovel.getPlaca()) == null) {
            automoveis.add(automovel);
        } else {
            System.out.println("Erro: A placa " + automovel.getPlaca() + " já existe.");
        }
    }

    public void removerAutomovel(String placa) {
        Automovel automovel = consultarAutomovel(placa);
        if (automovel != null) {
            automoveis.remove(automovel);
            System.out.println("Automóvel removido com sucesso.");
        } else {
            System.out.println("Erro: Automóvel com a placa " + placa + " não encontrado.");
        }
    }

    public void alterarAutomovel(String placa, Automovel novosDados) {
        Automovel automovel = consultarAutomovel(placa);
        if (automovel != null) {
            automovel.setModelo(novosDados.getModelo());
            automovel.setMarca(novosDados.getMarca());
            automovel.setAno(novosDados.getAno());
            automovel.setValor(novosDados.getValor());
            System.out.println("Automóvel atualizado com sucesso.");
        } else {
            System.out.println("Erro: Automóvel com a placa " + placa + " não encontrado.");
        }
    }

    public Automovel consultarAutomovel(String placa) {
        for (Automovel automovel : automoveis) {
            if (automovel.getPlaca().equals(placa)) {
                return automovel;
            }
        }
        return null;
    }

    public List<Automovel> listarAutomoveis(Comparator<Automovel> comparator) {
        automoveis.sort(comparator);
        return automoveis;
    }

    // --- Métodos de persistência ---

    public void loadData(String filename) {
        automoveis.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] campos = linha.split(",");
                if (campos.length == 5) {
                    String placa = campos[0];
                    String modelo = campos[1];
                    String marca = campos[2];
                    int ano = Integer.parseInt(campos[3]);
                    double valor = Double.parseDouble(campos[4]);
                    Automovel automovel = new Automovel(placa, modelo, marca, ano, valor);
                    automoveis.add(automovel);
                }
            }
        } catch (IOException e) {
            System.out.println("Arquivo de dados não encontrado. Um novo será criado ao salvar.");
        }
    }

    public void saveData(String filename) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (Automovel automovel : automoveis) {
                String linha = String.format("%s,%s,%s,%d,%.2f",
                        automovel.getPlaca(),
                        automovel.getModelo(),
                        automovel.getMarca(),
                        automovel.getAno(),
                        automovel.getValor());
                bw.write(linha);
                bw.newLine();
            }
        }
    }
}