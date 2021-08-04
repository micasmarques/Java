package br.ifpb.edu.entities.gerente;

import br.ifpb.edu.entities.Funcionário;

public class Gerente extends Funcionário {
    private double gratificação;

    public Gerente() {
        super();
        this.setGratificação( 0 );
    }

    public Gerente(String nome, int idade, String endereço, double salárioBase, double gratificação) {
        super(nome, idade, endereço, salárioBase);
        this.setGratificação( gratificação );
    }

    public double getGratificação() {
        return gratificação;
    }

    public void setGratificação(double gratificação) {
        if (gratificação >= 0) {
            this.gratificação = gratificação;
        }
    }

    @Override
    public double getSalárioBase() {
        return super.getSalárioBase() + this.getGratificação();
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        String tipo = "|Dados do Gerente|";
        str.append("\nSalário (Base): " + this.formatoMoeda(super.getSalárioBase()));
        str.append("\nGratificação: " + this.formatoMoeda(this.getGratificação()));
        str.append("\nSalário (Final): " + super.formatoMoeda(this.getSalárioBase()));
        return tipo + super.toString() + str;
    }
}
