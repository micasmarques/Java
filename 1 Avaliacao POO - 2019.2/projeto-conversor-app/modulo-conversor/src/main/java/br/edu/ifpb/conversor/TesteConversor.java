package br.edu.ifpb.conversor;

public class TesteConversor {
    public static void main(String[] args) {

        Conversor conversor = new Conversor();
        int valorASerConvertido = 15;

        String valorConvertido_Hexa = conversor.decimalParaHexadecimal(valorASerConvertido);
        System.out.println(valorConvertido_Hexa);

        String valorConvertido_Binário = conversor.decimalParaBinário(valorASerConvertido);
        System.out.println(valorConvertido_Binário);

    }
}
