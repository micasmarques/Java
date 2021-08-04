package br.ifpb.edu.entities.professor;

import br.ifpb.edu.entities.Funcionário;

public class Professor extends Funcionário {
    private double numHoras;

    public Professor() {
        super();
        this.setNumHoras( 0 );
    }

    public Professor(String nome, int idade, String endereço, double salário, double numHoras) {
        super(nome, idade, endereço, salário);
        this.setNumHoras( numHoras );
    }

    public double getNumHoras() {
        return numHoras;
    }

    public void setNumHoras(double numHoras) {
        if (numHoras >= 0) {
            this.numHoras = numHoras;
        }
    }

    @Override
    public double getSalárioBase() {
        return super.getSalárioBase() + this.getNumHoras();
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        String tipo = "|Dados do Professor|";
        str.append("\nSalário (Base): " + this.formatoMoeda(super.getSalárioBase()));
        str.append("\nNúmero de Horas: " + this.getNumHoras());
        str.append("\nSalário (Final): " + super.formatoMoeda(this.getSalárioBase()));
        return tipo + super.toString() + str;
    }
}
