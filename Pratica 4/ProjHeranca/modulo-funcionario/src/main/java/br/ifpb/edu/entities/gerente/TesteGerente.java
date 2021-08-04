package br.ifpb.edu.entities.gerente;

public class TesteGerente {
    public static void main(String[] args) {
        Gerente gerente = new Gerente(
                "Novo Gerente",
                45,
                "Ger End",
                1500,
                300
        );
        System.out.println(gerente + "\n---");

        gerente.setGratificação( 800 );

        System.out.println(gerente);
    }
}
