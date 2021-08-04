package br.ifpb.edu.entities;

public class TesteFuncionário {
    public static void main(String[] args) {
        Funcionário funcionário = new Funcionário(
                "Novo Funcionário",
                19,
                "Novo End",
                980.00
        );
        System.out.println(funcionário + "\n---");

        funcionário.setNome( "Novo Nome" );
        funcionário.setIdade( 20 );
        funcionário.setEndereço( "Outro End" );
        funcionário.setSalárioBase( 1000 );

        System.out.println(funcionário + "\n");
    }
}
