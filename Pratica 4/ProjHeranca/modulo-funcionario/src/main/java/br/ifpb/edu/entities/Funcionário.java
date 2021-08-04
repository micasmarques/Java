package br.ifpb.edu.entities;

import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Locale;

public class Funcionário {
    private Locale local = new Locale("pt", "BR");

    private String nome;
    private int matrícula;
    private int idade;
    private String endereço;
    private double salárioBase;

    private static int INCREMENTADOR = 1;

    public Funcionário() {
        this.setNome( "-Funcionário Sem Nome-" );
        this.setMatrícula( INCREMENTADOR );
        this.setIdade( 16 );
        this.setEndereço( "Sem Endereço" );
        this.setSalárioBase( 450.00 );
    }

    public Funcionário(String nome, int idade, String endereço, double salárioBase) {
        this.setNome( nome );
        this.setMatrícula( INCREMENTADOR );
        this.setIdade( idade );
        this.setEndereço( endereço );
        this.setSalárioBase(salárioBase);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome.length() > 0) {
            this.nome = nome;
        }
    }

    public int getMatrícula() {
        return matrícula;
    }

    private void setMatrícula(int número) {

        int ano = Calendar.getInstance().get(Calendar.YEAR);
        int mês = (Calendar.getInstance().get(Calendar.MONTH)) + 1;

        if (mês >= 7) {
            this.matrícula = Integer.parseInt(Integer.toString(ano) + String.format("%02d", 02) + String.format("%04d", número));
        } else {
            this.matrícula = Integer.parseInt(Integer.toString(ano) + String.format("%02d", 01) + String.format("%04d", número));
        }

        INCREMENTADOR++;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        if (idade >= 0) {
            this.idade = idade;
        }
    }

    public String getEndereço() {
        return endereço;
    }

    public void setEndereço(String endereço) {
        if (endereço.length() > 0) {
            this.endereço = endereço;
        }
    }

    public double getSalárioBase() {
        return salárioBase;
    }

    public void setSalárioBase(double salárioBase) {
        if (salárioBase > 0) {
            this.salárioBase = salárioBase;
        }
    }

    protected String formatoMoeda(double valor) {
        NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(local);
        return formatoMoeda.format(valor);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();

        str.append("\nMatrícula: " + this.getMatrícula());
        str.append("\nNome: " + this.getNome());
        str.append("\nIdade: " + this.getIdade());
        str.append("\nEndereço: " + this.getEndereço());

        return str.toString();
    }
}
