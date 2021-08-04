package br.edu.ifpb.conversor;

public class Conversor {

    public Conversor() { }

    public String decimalParaHexadecimal(int valor) {
        return Integer.toHexString(valor);
    }

    public String decimalParaBinário(int valor) {
        return Integer.toBinaryString(valor);
    }
}
