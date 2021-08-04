package br.com.micael.banco;

import br.com.guilherme.conta.contacorrente.ContaCorrente;
import br.com.guilherme.banco.exceptions.*;

// Funções Auxiliares - Apache
import org.apache.commons.lang3.*;

// Java Util
import java.util.*;

public class Banco {
    private static final String BANCO_SEM_NOME = "--- Banco Sem Nome ---";

    private String bankName;
    private Set<ContaCorrente> listaDeContasCorrente;

    {
        this.setListaDeContasCorrente(new HashSet<>());
    }

    public Banco() {
        this.setBankName( BANCO_SEM_NOME );
    }

    public Banco(String bankName) {
        this.setBankName(bankName);
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        if (StringUtils.isNotBlank(bankName)) {
            this.bankName = bankName;
        } else {
            throw new NomeInválidoException();
        }
    }

    public boolean adicionaConta(ContaCorrente cc) {
        if (!existeConta(cc.getNúmero())) {
            return listaDeContasCorrente.add(cc);
        } else {
            throw new ContaJáCadastradaException();
        }
    }

    public boolean removeConta(int número) {
        for (ContaCorrente cc : listaDeContasCorrente) {
            if (cc.getNúmero() == número) {
                return listaDeContasCorrente.remove(cc);
            }
        }
        return false;
    }

    public boolean existeConta(int número) {
        return  this.getListaDeContasCorrente()
                    .stream()
                    .anyMatch(contaCorrente -> número == contaCorrente.getNúmero());
    }

    public int quantidadeDeContas() {
        return listaDeContasCorrente.size();
    }

    public Set<ContaCorrente> getListaDeContasCorrente() {
        return listaDeContasCorrente;
    }

    private void setListaDeContasCorrente(Set<ContaCorrente> listaDeContasCorrente) {
        this.listaDeContasCorrente = listaDeContasCorrente;
    }

    @Override
    public String toString() {

        StringBuilder str = new StringBuilder();

        str.append("|Banco ").append(bankName).append("|").append("\n");

        for (ContaCorrente cc : listaDeContasCorrente) {
            str.append(cc.toString()).append("\n");
        }

        return str.toString();
    }
}
