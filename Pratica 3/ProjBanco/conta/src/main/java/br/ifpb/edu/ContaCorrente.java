package br.ifpb.edu;

import java.text.NumberFormat;
import java.util.Locale;

public class ContaCorrente {
    private Locale local = new Locale("pt", "BR");

    private int número;
    private String titular;
    private double saldo;

    public ContaCorrente() {
        this.setNúmero( 0 );
        this.setTitular( "--- Sem Nome ---");
        this.setSaldo( 10 );
    }

    public ContaCorrente(int número, String titular, double saldo) {
        this.setNúmero( número );
        this.setTitular( titular );
        this.setSaldo( saldo );
    }

    public int getNúmero() {
        return número;
    }

    public void setNúmero(int número) {
        if (número > 0 ) {
            this.número = número;
        }
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        if (titular.length() > 0) {
            this.titular = titular;
        }
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        if (saldo >= 0) {
            this.saldo = saldo;
        }
    }

    public void depositar(double quantia) {
        if (quantia > 0) {
            this.setSaldo(this.getSaldo() + quantia);
        }
    }

    // <default>
    public double sacar(double quantia) {
        if ( this.getSaldo() > quantia && quantia > 0 ) {
            this.setSaldo( this.descontaCPMF(quantia) );
            return quantia;
        } else {
            return -1;
        }
    }

    private double calculaCPMF(double quantia) {
        return (quantia * 0.01);
    }

    private double descontaCPMF(double quantia) {
        return (this.getSaldo() - (quantia + this.calculaCPMF(quantia)));
    }

    @Override
    public String toString() {
        NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(local);
        StringBuilder str = new StringBuilder();

        str.append(String.format("|Dados da Conta %d|\n", this.getNúmero()));
        str.append("Titular: " + this.getTitular() + "\n");
        str.append("Saldo: " + formatoMoeda.format(this.getSaldo()));

        return str.toString();
    }
}
