package br.com.micael.conta.contacorrente;

import static java.lang.System.*;

public class TesteContaCorrente {
    public static void main(String[] args) {

        ContaCorrente c1 = new ContaCorrente();
        c1.setTitular("Exemplo Um");
        c1.setSaldo(500);
        out.println(c1);

        out.println("-----");

        ContaCorrente c2 = new ContaCorrente( "Exemplo Dois", "12345678910", "123", 500);
        out.println(c2);
        c2.depositar(500);
        out.println(c2);
        out.println("Valor sacado: " + c2.sacar(500));
        out.println(c2);

        out.println("-----");

        ContaCorrente c3 = new ContaCorrente( "Gui", "12345678915", "123", 1000);
        double dinheiroSacado = c3.sacar(100);
        out.println(dinheiroSacado);
        out.println(c3.getSaldo());

    }
}
