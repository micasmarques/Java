package br.ifpb.edu.cli.views;

import br.ifpb.edu.cli.controllers.Menu;
import br.ifpb.edu.cli.controllers.enums.OpçõesDoMenuFuncionário;
import br.ifpb.edu.cli.controllers.enums.OpçõesDoMenuUniversidade;
import br.ifpb.edu.entities.Funcionário;
import br.ifpb.edu.entities.gerente.Gerente;
import br.ifpb.edu.entities.professor.Professor;
import br.ifpb.edu.universidade.Universidade;

import java.util.Scanner;

public class MainCLI {
    public static void main(String[] args) {

        Universidade universidade = new Universidade();
        Menu menu = new Menu();

        menu.exibirSaudações();
        universidade.setNome(MainCLI.inputString());

        while (true) {

            String nome;
            int idade;
            String endereço;
            double salárioBase;

            int matrícula;

            while (true) {
                menu.separador();
                menu.exibirMenuUniversidade(universidade.getNome());
                menu.setOpção(MainCLI.inputInt());
                if (menu.getOpção() < 0 || menu.getOpção() > OpçõesDoMenuUniversidade.values().length ) {
                    menu.opçãoInválida();
                } else {
                    break;
                }
            }

            OpçõesDoMenuUniversidade opçãoUni = OpçõesDoMenuUniversidade.values()[menu.getOpção()];

            menu.separador();
            switch (opçãoUni) {
                case RENOMEAR_UNIVERSIDADE:
                    menu.digite("o novo nome da Universidade");
                    universidade.setNome(MainCLI.inputString());
                    menu.printaln("Novo Nome: " + universidade.getNome());
                    break;

                case DADOS_UNIVERSIDADE:
                    menu.printHeader("|Dados da Universidade|", 3);
                    menu.printaln("Nome: " + universidade.getNome());
                    menu.printaln(String.format(
                            "%1$s %2$td de %2$tB de %2$tY às %2$tr",
                            "Data de Criação: ",
                            universidade.getFundação()
                            )
                    );
                    menu.printaln("Quantidade de Funcionários: " + universidade.quantidadeDeFuncionários());
                    break;

                case CADASTRAR_FUNCIONARIO:

                    menu.printHeader("|Cadastrando Funcionário|", 3);

                    while (true) {
                        menu.exibirMenuFuncionário();
                        menu.setOpção(MainCLI.inputInt());
                        if (menu.getOpção() < 0 || menu.getOpção() > OpçõesDoMenuFuncionário.values().length) {
                            menu.opçãoInválida();
                        } else {
                            break;
                        }
                    }

                    OpçõesDoMenuFuncionário opçãoFunc = OpçõesDoMenuFuncionário.values()[menu.getOpção()];

                    menu.separador();
                    switch (opçãoFunc) {
                        case CADASTRAR_GERENTE:
                            Gerente gerente;
                            double gratificação;

                            menu.printHeader("|Cadastrando Gerente|", 3);

                            menu.digite("o nome do gerente");
                            nome = MainCLI.inputString();

                            menu.digite("a idade do gerente");
                            idade = MainCLI.inputInt();

                            menu.digite("o endereço do gerente");
                            endereço = MainCLI.inputString();

                            menu.digite("o salário base do gerente");
                            salárioBase = MainCLI.inputDouble();

                            menu.digite("a gratificação do gerente");
                            gratificação = MainCLI.inputDouble();

                            gerente = new Gerente(nome, idade, endereço, salárioBase, gratificação);

                            if (universidade.cadastraFuncionário(gerente)) {
                                menu.printaln("Gerente cadastrado com sucesso!");
                                System.out.println(gerente);
                            } else {
                                menu.printaln("Houve um problema ao cadastrar este Gerente!");
                            }

                            break;

                        case CADASTRAR_PROFESSOR:
                            Professor professor;
                            double numHoras;

                            menu.printHeader("|Cadastrando Professor|", 3);

                            menu.digite("o nome do professor");
                            nome = MainCLI.inputString();

                            menu.digite("a idade do professor");
                            idade = MainCLI.inputInt();

                            menu.digite("o endereço do professor");
                            endereço = MainCLI.inputString();

                            menu.digite("o salário base do professor");
                            salárioBase = MainCLI.inputDouble();

                            menu.digite("o número de horas do professor");
                            numHoras = MainCLI.inputDouble();

                            professor = new Professor(nome, idade, endereço, salárioBase, numHoras);

                            if (universidade.cadastraFuncionário(professor)) {
                                menu.printaln("Professor cadastrado com sucesso!");
                                System.out.println(professor);
                            } else {
                                menu.printaln("Houve um problema ao cadastrar este Professor!");
                            }
                            break;

                        case VOLTAR:
                            break;

                        case SAIR:
                            menu.saindo();
                            MainCLI.sair();
                    }
                    break;

                case REMOVER_FUNCIONARIO:
                    menu.printHeader("|Removendo Funcionário|", 3);
                    menu.digite("a matrícula do funcionário");
                    matrícula = inputInt();
                    if (universidade.existeFuncionário(matrícula)) {
                        universidade.removeFuncionário(matrícula);
                        menu.printaln("Funcionário removido com sucesso!");
                    } else {
                        menu.printaln("Não foi encontrado funcionário com esta matrícula!");
                    }
                    break;

                case LISTAR_FUNCIONARIOS:
                    menu.printHeader("|Listando Todos os Funcionários|", 3);
                    for (Funcionário funcionário : universidade.getListaDeFuncionários()) {
                        System.out.println(funcionário);
                        System.out.println("---");
                    }
                    break;

                case EDITAR_FUNCIONARIO:
                    menu.digite("a matrícula do funcionário a ser editado");
                    matrícula = inputInt();
                    if (universidade.existeFuncionário(matrícula)) {
                        System.out.println("Funcionalidade não implementada ainda...");
                    }
                    break;

                case EXIBIR_FUNCIONARIO:
                    menu.digite("a matrícula do funcionário");
                    matrícula = inputInt();
                    if (universidade.existeFuncionário(matrícula)) {
                        for (Funcionário funcionário : universidade.getListaDeFuncionários()) {
                            if (funcionário.getMatrícula() == matrícula) {
                                System.out.println(funcionário);
                            }
                        }
                    } else {
                        menu.printaln("Não foi encontrado funcionário com esta matrícula!");
                    }
                    break;

                case SAIR:
                    menu.saindo();
                    MainCLI.sair();
            }
        }

    }

    private static int inputInt() {
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }

    private static String inputString() {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    private static double inputDouble() {
        Scanner input = new Scanner(System.in);
        return input.nextDouble();
    }

    private static void sair() {
        System.exit(0);
    }

}
