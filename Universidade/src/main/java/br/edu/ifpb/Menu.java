package br.edu.ifpb;

import java.util.Scanner;

public class Menu
{
    private int matricula;
    private String nome;
    private int idade;
    private double salario;
    private int numHoras;
    private double comissao;
    private int escolha;

    private Universidade universidade = new Universidade();

    public void exibirMenu()
    {

        System.out.printf(".:::Sistema da Universidade:::.\n" +
                            "Cadastro de Funcion\341rios\n");

        while (true)
        {

            Scanner input = new Scanner(System.in);

            System.out.printf("========================\n" +
                    "   1. Cadastrar Funcion\341rio\n" +
                    "   2. Cadastrar Professor\n" +
                    "   3. Cadastrar Gerente\n" +
                    "   9. Exibir n\372mero de funcionarios cadastrados\n" +
                    "   0. Sair\n" +
                    "   Digite uma opção: ");
            // Ler opção com scanner:
            int opcao = input.nextInt();

            if (opcao == 0) {
                // Sair
                System.out.println("Saindo.");
                break;
            }

            else {

                if (opcao == 9) {

                    universidade.getQuantidadeFuncionarios();

                } else if (opcao == 1) {

                    System.out.println("\n  -------------\n|Cadastrando novo Funcion\341rio|");
                    this.matricula = capturaMatricula();
                    this.nome = capturaNome();
                    this.idade = capturaIdade();
                    this.salario = capturaSalario();

                    Funcionario funcionario = new Funcionario(this.matricula, this.nome, this.idade, this.salario);
                    if(universidade.adicionarFuncionario(funcionario))
                        System.out.printf("|Novos Dados|\n" + funcionario.toString());

                    this.escolha = capturaEscolha();

                }
                else if (opcao == 2) {

                    System.out.println("\n  -------------\n|Cadastrando novo Professor|");
                    this.matricula = capturaMatricula();
                    this.nome = capturaNome();
                    this.idade = capturaIdade();
                    this.salario = capturaSalario();
                    System.out.printf("Digite o n\372mero de horas de disciplinas: ");
                    this.numHoras = input.nextInt();

                    Professor professor = new Professor(this.matricula, this.nome, this.idade, this.salario, this.numHoras);
                    if(universidade.adicionarFuncionario(professor))
                        System.out.printf("|Novos Dados|\n" + professor.toString());

                    this.escolha = capturaEscolha();

                }
                else if (opcao == 3) {

                    System.out.println("\n  -------------\n|Cadastrando novo Gerente|");
                    this.matricula = capturaMatricula();
                    this.nome = capturaNome();
                    this.idade = capturaIdade();
                    this.salario = capturaSalario();
                    System.out.printf("Digite a comissão: ");
                    this.comissao = input.nextDouble();

                    Gerente gerente = new Gerente(this.matricula, this.nome, this.idade, this.salario, this.comissao);
                    if(universidade.adicionarFuncionario(gerente))
                        System.out.printf("|Novos Dados|\n" + gerente.toString());

                    this.escolha = capturaEscolha();
                }

                if (this.escolha == 0) {
                    System.out.println("Saindo.");
                    break;
                }
                else if (this.escolha == 1) {
                    System.out.printf("--------------------\n");
                }
                else if (this.escolha == 2) {
                    universidade.getQuantidadeFuncionarios();
                }

            }
        }
    }

    private static int capturaMatricula() {
        Scanner input = new Scanner( System.in );
        System.out.printf("Digite a matrícula: ");
        return input.nextInt();
    }

    private static String capturaNome() {
        Scanner input = new Scanner( System.in );
        System.out.printf("Digite o nome: ");
        return input.nextLine();
    }

    private static int capturaIdade() {
        Scanner input = new Scanner( System.in );
        System.out.printf("Digite a idade: ");
        return input.nextInt();
    }

    private static double capturaSalario() {
        Scanner input = new Scanner( System.in );
        System.out.printf("Digite o sal\341rio: ");
        return input.nextDouble();
    }

    private static int capturaEscolha() {
        Scanner input = new Scanner( System.in );

        System.out.printf("\n -------------" +
                            "\n O que deseja fazer?\n " +
                            "\t1. Cadastrar mais funcionarios\n" +
                            "\t2. Exibir total de funcionarios cadastrados\n" +
                            "\t0. Sair\n");

        return input.nextInt();
    }

}
