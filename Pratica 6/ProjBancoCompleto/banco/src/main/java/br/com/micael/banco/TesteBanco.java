package br.com.micael.banco;

import br.com.guilherme.conta.contacorrente.ContaCorrente;

import static java.lang.System.*;

public class TesteBanco {
    public static void main(String[] args) {

        Banco novoBanco = new Banco("Gui");

        ContaCorrente acc1 = new ContaCorrente("Gui", "12345678925", "123", 100);
        ContaCorrente acc2 = new ContaCorrente("Esdras", "12345678924", "123", 250);

        novoBanco.adicionaConta(acc1);
        novoBanco.adicionaConta(acc2);

        out.println(novoBanco);

        novoBanco.removeConta(1);

        out.println(novoBanco);

    }
}
