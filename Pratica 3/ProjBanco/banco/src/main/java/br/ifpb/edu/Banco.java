package br.ifpb.edu;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private String bankName;
    private List<ContaCorrente> listaDeContasCorrente;

    {
        this.setListaDeContasCorrente(new ArrayList<>());
    }

    public Banco() {
        this.setBankName("--- Banco Sem Nome ---");
    }

    public Banco(String bankName) {
        this.setBankName(bankName);
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        if (bankName.length() > 0) {
            this.bankName = bankName;
        }
    }

    public boolean adicionaConta(ContaCorrente cc) {
        if (existeConta(cc.getNúmero())) {
            return false;
        } else {
            return listaDeContasCorrente.add(cc);
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
        for (ContaCorrente tmp : listaDeContasCorrente) {
            if (tmp.getNúmero() == número) {
                return true;
            }
        }
        return false;
    }

    public int quantidadeDeContas() {
        return listaDeContasCorrente.size();
    }

    public List<ContaCorrente> getListaDeContasCorrente() {
        return listaDeContasCorrente;
    }

    private void setListaDeContasCorrente(List<ContaCorrente> listaDeContasCorrente) {
        this.listaDeContasCorrente = listaDeContasCorrente;
    }

    @Override
    public String toString() {

        StringBuilder str = new StringBuilder();

        str.append("|Banco " + bankName + "|" + "\n");

        for (ContaCorrente cc : listaDeContasCorrente) {
            str.append(cc.toString() + "\n");
        }

        return str.toString();
    }
}
