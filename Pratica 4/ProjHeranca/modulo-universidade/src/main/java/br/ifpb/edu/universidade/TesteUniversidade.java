package br.ifpb.edu.universidade;

import br.ifpb.edu.entities.gerente.Gerente;
import br.ifpb.edu.entities.professor.Professor;

public class TesteUniversidade {
    public static void main(String[] args) {
        Universidade universidade = new Universidade();
        System.out.println(universidade);

        universidade.setNome("Novo Nome");
        Professor professor = new Professor("Prof 1", 23, "Prof End", 1200, 45);
        Gerente gerente = new Gerente("Ger 1", 35, "Ger End", 1500, 300);
        universidade.cadastraFuncionário(professor);
        universidade.cadastraFuncionário(gerente);
        universidade.cadastraFuncionário(new Professor());
        universidade.cadastraFuncionário(new Gerente());

        System.out.println(universidade);
    }
}
