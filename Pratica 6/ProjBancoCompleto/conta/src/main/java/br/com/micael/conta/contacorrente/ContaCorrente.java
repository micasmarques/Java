package br.com.micael.conta.contacorrente;

import br.com.micael.conta.Conta;
import br.com.micael.conta.exceptions.*;

// Java Utils
import java.text.NumberFormat;
import java.util.*;

public class ContaCorrente extends Conta {

    private static int INCREMENTADOR = 0;

    {
        this.setNúmero( ++INCREMENTADOR );
        this.setDataDeCadastro( new Date() );
    }

    public ContaCorrente() {
        this.setTitular( TITULAR_SEM_NOME );
        this.setCPF( TITULAR_SEM_CPF );
        this.setSenha( SENHA_DEFAULT );
        this.setSaldo( SALDO_INICIAL_DEFAULT );
    }

    public ContaCorrente(String titular, String CPF, String senha, double saldo) {
        this.setTitular( titular );
        this.setCPF( CPF );
        this.setSenha( senha );
        this.setSaldo( saldo );
    }

    public void depositar(double quantia) {
        if (quantia > 0) {
            this.setSaldo(this.getSaldo() + quantia);
        } else if (quantia == 0) {
            throw new IgualAZeroException();
        } else {
            throw new QuantiaNegativaException();
        }
    }

    public double sacar(double quantia) {
        if ( (quantia > 0) && (this.getSaldo() > (quantia + this.calculaCPMF(quantia))) ) {
            this.setSaldo( this.descontaCPMF(quantia) );
            return quantia;
        } else if (quantia == 0) {
            throw new IgualAZeroException();
        } else if (quantia < 0) {
            throw new QuantiaNegativaException();
        } else {
            throw new SaldoInsuficienteException();
        }
    }

    private double calculaCPMF(double quantia) {
        return (quantia * 0.01);
    }

    private double descontaCPMF(double quantia) {
        return (this.getSaldo() - (quantia + this.calculaCPMF(quantia)));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContaCorrente that = (ContaCorrente) o;

        return this.getCPF().equals(that.getCPF());
    }

    @Override
    public int hashCode() {
        return this.getCPF().hashCode();
    }

    @Override
    public String toString() {
        NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(local);

        return String.format("|Dados da Conta %d|\n", this.getNúmero()) +
                             "Titular: " + this.getTitular() + "\n" +
                             "CPF: " + this.getCPF() + "\n" +
                             "Saldo: " + formatoMoeda.format(this.getSaldo()) + "\n" +
                             String.format("%1$s %2$td de %2$tB de %2$tY às %2$tr",
                                    "Membro Desde: ", this.getDataDeCadastro() );
    }
}
