package br.ifpb.edu;

import java.util.*;

public class Menu {
    private int opção;

    public int getOpção() {
        return opção;
    }

    public void setOpção(int opção) {
        this.opção = opção - 1;
    }

    public void exibirMenuBanco(String nomeDoBanco) {
        System.out.print("--- Menu do Banco " + nomeDoBanco + " ---");

        EnumSet.allOf(OpçõesDoMenuBanco.class).forEach(
                OpçõesDoMenuBanco -> System.out.println(
                        "\n\t " +
                                OpçõesDoMenuBanco.ordinal()+1 +
                                ". " +
                                OpçõesDoMenuBanco.toString()
                )
        );
        System.out.println(" Digite uma opção:__");
    }

    public void exibirMenuContaCorrente(int número) {
        System.out.print("--- Menu da Conta " + número + " ---");
        EnumSet.allOf(OpçõesDoMenuContaCorrente.class).forEach(
                OpçõesDoMenuContaCorrente -> System.out.println(
                        "\n\t " +
                                OpçõesDoMenuContaCorrente.ordinal()+1 +
                                ". " +
                                OpçõesDoMenuContaCorrente.toString()
                )
        );
        System.out.println(" Digite uma opção:__");
    }

    public void saudações() {
        System.out.println("| Bem Vindo ao Projeto Banco/Conta Corrente |");
        System.out.print("Antes de proseguir, digite o nome do banco: ");
    }
}
