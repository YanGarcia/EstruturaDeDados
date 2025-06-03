# Cadastro de Automóveis

Este projeto é um sistema de gerenciamento de automóveis, implementado em Java, que utiliza o padrão de arquitetura MVC (Model-View-Controller). O sistema permite a inclusão, exclusão, alteração, consulta e listagem de automóveis, armazenando os dados em um arquivo de texto para persistência.

## Estrutura do Projeto

- **src/model/Automovel.java**: Contém a classe `Automovel`, que representa um automóvel com os seguintes atributos:
  - `String placa` (chave única)
  - `String modelo`
  - `String marca`
  - `int ano`
  - `double valor`
  
  A classe inclui métodos para acessar e modificar esses atributos, além de um método para converter o objeto em formato CSV para armazenamento em arquivo.

- **src/controller/AutomovelController.java**: Contém a classe `AutomovelController`, que gerencia as operações relacionadas aos objetos `Automovel`. Os métodos incluem:
  - `inserirAutomovel`: Adiciona um novo automóvel à lista e verifica se a placa já existe.
  - `removerAutomovel`: Remove um automóvel com base na placa.
  - `alterarAutomovel`: Atualiza os detalhes de um automóvel identificado pela placa.
  - `consultarAutomovel`: Recupera e exibe os detalhes de um automóvel pela placa.
  - `listarAutomoveis`: Lista todos os automóveis ordenados por placa, modelo ou marca utilizando `Comparator`.

- **src/view/AutomovelView.java**: Contém a classe `AutomovelView`, que gerencia a interface do usuário. Inclui métodos para exibir o menu, obter entradas do usuário e mostrar resultados.

- **src/Main.java**: Este arquivo é o ponto de entrada da aplicação. Inicializa o controlador e a visualização, carrega dados do arquivo `dados.txt` usando `BufferedReader` e inicia o loop de interação com o usuário.

- **dados.txt**: Utilizado para persistência de dados. Armazena os objetos `Automovel` em formato CSV (placa,modelo,marca,ano,valor) para carregamento e salvamento de dados.

## Instruções de Uso

1. Compile o projeto.
2. Execute a classe `Main`.
3. Siga as instruções exibidas no console para gerenciar o cadastro de automóveis.

## Funcionalidades

- Inclusão de novos automóveis.
- Remoção de automóveis existentes.
- Alteração de dados de automóveis.
- Consulta de automóveis por placa.
- Listagem de automóveis ordenados por placa, modelo ou marca.
- Persistência de dados em arquivo texto.