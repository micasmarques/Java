package br.edu.ifpb;

class Calculadora
{
    private String descricao;
    private double memoria;

    double somar(double umNumero, double outroNumero) {
        return umNumero + outroNumero;
    }

    double subtrair(double umNumero, double outroNumero) {
        return umNumero - outroNumero;
    }

    double multiplicar(double umNumero, double outroNumero) {
        return umNumero * outroNumero;
    }

    double dividir(double umNumero, double outroNumero) {
        return umNumero / outroNumero;
    }

    void gravarMemoria(double umResultado) {
        this.memoria = umResultado;
    }

    double lerMemoria() {
        return this.memoria;
    }

    void alterarDescricao(String descricao) {
        this.descricao = descricao;
    }

    String consultarDescricao() {
        return this.descricao;
    }
}
