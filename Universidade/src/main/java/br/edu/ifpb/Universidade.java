package br.edu.ifpb;

import java.util.ArrayList;

public class Universidade {
    ArrayList<Funcionario> funcionarios;

    Universidade() {
        funcionarios = new ArrayList<>();
    }

    public boolean adicionarFuncionario(Funcionario func) {
        for( Funcionario f : funcionarios)
            if( f.getMatricula() == func.getMatricula()) {
                System.out.println("Matrícula já cadastrada!");
                System.out.printf("|Dados|\n" + f.toString());
                return false;
            }

        System.out.println("\n  -------------\n Funcionario cadastrado com sucesso!\n -------------");
        return funcionarios.add(func);
    }

    public boolean removerFuncionario(int matricula) {
        for( Funcionario f : funcionarios) {
            if (f.getMatricula() == matricula) {
                System.out.println("Funcion\341rio removido com sucesso!");
                return funcionarios.remove(f);
            }
        }

        System.out.println("Não foi encontrado funcionario com essa matricula.");
        return false;
    }

    public int getQuantidadeFuncionarios() {
        System.out.println("Total de funcionarios cadastrados: ");
        return funcionarios.size();
    }

}
