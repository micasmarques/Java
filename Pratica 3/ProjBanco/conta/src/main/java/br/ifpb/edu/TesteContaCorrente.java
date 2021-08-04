package br.ifpb.edu;

public class TesteContaCorrente {
    public static void main(String[] args) {

        ContaCorrente c1 = new ContaCorrente();
        c1.setNúmero( 1 );
        c1.setTitular("Exemplo 1");
        c1.setSaldo(500);
        System.out.println(c1);

        System.out.println("-----");

        ContaCorrente c2 = new ContaCorrente(2, "Exemplo 2", 250);
        System.out.println(c2);
        c2.depositar(273);
        System.out.println(c2);
        System.out.println("Valor sacado: " + c2.sacar(100));
        System.out.println(c2);

    }
}
