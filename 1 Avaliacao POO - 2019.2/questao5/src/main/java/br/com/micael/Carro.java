package br.com.micael;

import java.util.Calendar;

public class Carro {
    private int chassi;

    private static int INC = 1;

    {
        this.setChassi(INC++);
    }

    public int getChassi() {
        return chassi;
    }

    public void setChassi(int número) {
        int ano = Calendar.getInstance().get(Calendar.YEAR);
        int mês = (Calendar.getInstance().get(Calendar.MONTH)) + 1;

        if (mês >= 7) {
            this.chassi = Integer.parseInt(Integer.toString(ano) + String.format("%02d", 02) + String.format("%04d", número));
        } else {
            this.chassi = Integer.parseInt(Integer.toString(ano) + String.format("%02d", 01) + String.format("%04d", número));
        }
    }

    public String nome() {
        return "Sem Nome";
    }

    public String marca() {
        return "Sem Marca";
    }

    public int quantidadeDePortas() {
        return 2;
    }

    public TipoDeCarro tipoDeCarro() {
        return TipoDeCarro.COUPE;
    }

    public double velocidadeMaxima() {
        return 350.00;
    }

    @Override
    public String toString() {
        return "|Dados do Carro|" + "\n" +
                "Nome: " + this.nome() + "\n" +
                "Marca: " + this.marca() + "\n" +
                "Chassi: " + this.getChassi() + "\n" +
                "Quantidade De Portas: " + this.quantidadeDePortas() + "\n" +
                "Tipo do Carro: " + this.tipoDeCarro() + "\n" +
                "Velocidade Máxima: " + this.velocidadeMaxima();
    }
}
