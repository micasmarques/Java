package br.ifpb.edu.cli.controllers;

import br.ifpb.edu.cli.controllers.enums.OpçõesDoMenuFuncionário;
import br.ifpb.edu.cli.controllers.enums.OpçõesDoMenuUniversidade;

import java.util.EnumSet;

public class Menu {
    private int opção;

    public int getOpção() {
        return opção;
    }

    public void setOpção(int opção) {
        this.opção = opção - 1;
    }

    public void exibirMenuUniversidade(String nomeDaUniversidade) {
        this.printHeader("Menu da Universidade " + nomeDaUniversidade, 3);

        this.printa("\t O que deseja fazer?");
        EnumSet.allOf(OpçõesDoMenuUniversidade.class).forEach(
                OpçõesDoMenuUniversidade -> System.out.print(
                        "\n\t" +
                        (OpçõesDoMenuUniversidade.ordinal() +1) +
                        ". " +
                        OpçõesDoMenuUniversidade.toString()
                )
        );

        System.out.print("\n Digite uma opção:__");
    }

    public void exibirMenuFuncionário() {
        System.out.println("Selecione o tipo de funcionário que deseja cadastrar:");

        EnumSet.allOf(OpçõesDoMenuFuncionário.class).forEach(
                OpçõesDoMenuFuncionário -> System.out.print(
                        "\n\t" +
                        (OpçõesDoMenuFuncionário.ordinal() +1) +
                        ". " +
                        OpçõesDoMenuFuncionário.toString()
                )
        );

        System.out.print("\n Digite uma opção:__");
    }

    public void exibirSaudações() {
        this.printHeader("Bem Vindo ao Projeto Herança", 5);
        this.separador();
        System.out.print("Antes de continuar, digite o nome da Universidade: ");
    }

    public void printHeader(String título, int qtdDeTraços) {
        String header = String.format("|%s %s %s|", "-".repeat(qtdDeTraços), título, "-".repeat(qtdDeTraços));
        System.out.println (
                String.format("%s\n%s\n%s", "-".repeat(header.length()), header, "-".repeat(header.length()))
        );
    }

    public void digite(String msg) {
        System.out.print("- Digite " + msg + ":__");
    }

    public void printaln(String msg) {
        System.out.println(msg);
    }

    public void printa(String msg) {
        System.out.print(msg);
    }

    public void opçãoInválida() {
        System.out.println("Opção Inválida!");
    }

    public void separador() {
        System.out.println("-----");
    }

    public void saindo() {
        System.out.println("Saindo do programa...");
        System.out.println("Volte sempre! :)");
    }
}
