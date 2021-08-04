package br.com.micael;

public class Fusca extends Carro {
    @Override
    public String nome() {
        return "Fusca";
    }

    @Override
    public String marca() {
        return "VW";
    }

    @Override
    public int quantidadeDePortas() {
        return 4;
    }

    @Override
    public TipoDeCarro tipoDeCarro() {
        return TipoDeCarro.HATCHBACK;
    }

    @Override
    public double velocidadeMaxima() {
        return 150.00;
    }
}
