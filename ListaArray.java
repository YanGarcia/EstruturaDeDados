package util;

public class ListaArray {
//
//CONSTANTES - Sempre definidas com todas as letras maiúsculas. Ao invés de usar uma litera
//             (valor) no codigo, devemos usar uma constante

    final public static int TAMANHO_INICIAL = 3;
    final public static int FATOR_CRESCIMENTO = 5;
    final public static int NAO_ESTA_PRESENTE = - 1;
// ATRIBUTOS
    private Object[] arrayInterno;
    private int numElementos;
// MÉTODOS

    public ListaArray() {
        this.numElementos = 0; // ---- Não precisaria, ja que e a inicialização default
        this.arrayInterno = new Object[TAMANHO_INICIAL];
    }

    /**
     * Verifica a necessidade de crescimento do array interno. Este método é
     * privado, pois so deve ser visivel internamente a classe ListaArray
     */
    private void verificarNecessidadeDeCrescimento() {
// Obtendo o tamanho do array referenciado por this. arrayInterno
        int tamanho = this.arrayInterno.length;
// Se o tamanho é igual ao número de elementos, é porque o arrayInterno está cheio
// Então precisamos de um novo array
        if (tamanho == this.numElementos) {
// Criação de um array maior
            Object[] novoArray = new Object[tamanho + FATOR_CRESCIMENTO];
// Copiando as referências que estão no arrayInterno para o novo array
            for (int i = 0; i < tamanho; i++) {
                novoArray[i] = this.arrayInterno[i];
            }
// O novo array passa a ser o arrayInterno (o antigo será eliminado pelo garbage collection)
            this.arrayInterno = novoArray;
        }
    }

    /**
     * Adiciona a referência para um novo elemento no final do arrayInterno
     *
     * @param elemento - referência para o objeto a ser adicionado na ListaArray
     * @return Informa se o elemento foi adicionado
     */
    public boolean adicionar(Object elemento) {
// Verificando se o arrayInterno tem espaço para a inclusão do elemento
        this.verificarNecessidadeDeCrescimento();
// Colocando a referência para o elemento na primeira posição livre do arrayInterno
        this.arrayInterno[this.numElementos] = elemento;
// Incrementamos o numElementos
        this.numElementos++;
// Informamos que a adição foi feita com sucesso
        return true;

    }

    /**
     * Adiciona a referência para um novo elemento na posição indicada
     *
     * @param elemento - referência para o objeto a ser adicionado na ListaArray
     * @return true: Se a posição for plausivel; false: se posição for invalida
     *
     */
    public boolean adicionar(Object elemento, int posicao) {
// Verificando se a posição indicada é plausível. Não pode ser negativa,
// pois não há posição negativa em uma lista; não pode ser maior que o
// numElementos, pois não podemos deixar posições nulas ("buracos") no array
        if (posicao < 0 || posicao > this.numElementos) {
            return false;
        }
// Verificando se o arrayInterno tem espaço para a inclusão do elemento
        this.verificarNecessidadeDeCrescimento();
// Deslocando os elementos para abrir espaço para o elemento no array na
// posição indicada
        for (int i = this.numElementos; i > posicao; i--) {
            this.arrayInterno[i] = this.arrayInterno[i - 1];
        }
// Colocando a referência para o elemento na posição passada
        this.arrayInterno[posicao] = elemento;
// Informamos que a adição foi feita com sucesso.
        return true;
    }
}
