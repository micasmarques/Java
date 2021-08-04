package br.com.micael.cli.menu;

import br.com.micael.cli.enums.*;
import br.com.micael.cli.exceptions.OpçãoInválidaException;

import java.util.EnumSet;

import static java.lang.System.*;

public class Menu {
    private int opção;

    public int getOpção() {
        return opção;
    }

    public void setOpção(int opção) {
        if (opção > 0 && opção <= OpçõesDoMenuBanco.values().length) {
            this.opção = opção - 1;
        } else {
            throw new OpçãoInválidaException();
        }
    }

    public void saudações() {
        println("| Bem Vindo ao Projeto Banco/Conta Corrente |");
    }

    public void exibirMenuBanco(String nomeDoBanco) {
        println("--- Menu do Banco " + nomeDoBanco + " ---");
        print("  O que deseja fazer?");

        EnumSet.allOf(OpçõesDoMenuBanco.class).forEach(
                OpçõesDoMenuBanco -> out.print(
                        "\n\t " +
                                (OpçõesDoMenuBanco.ordinal() +1) +
                                ". " +
                                OpçõesDoMenuBanco.toString()
                )
        );

        print("\n\t Digite uma opção:__");
    }

    public void exibirMenuContaCorrente(int número) {
        println("--- Menu da Conta " + número + " ---");
        print("  O que deseja fazer?");

        EnumSet.allOf(OpçõesDoMenuContaCorrente.class).forEach(
                OpçõesDoMenuContaCorrente -> out.print(
                        "\n\t " +
                                (OpçõesDoMenuContaCorrente.ordinal() +1) +
                                ". " +
                                OpçõesDoMenuContaCorrente.toString()
                )
        );

        print("\n\t Digite uma opção:__");
    }

    public void println(String msg) {
        out.println(msg);
    }

    public void print(String msg) {
        out.print(msg);
    }
}
