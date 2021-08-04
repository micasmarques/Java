package br.com.micael.cli;

// Módulo banco
import br.com.micael.banco.*;
import br.com.micael.banco.exceptions.*;

// Módulo Conta
import br.com.micael.conta.contacorrente.ContaCorrente;

// Módulo CLI
import br.com.micael.cli.exceptions.OpçãoInválidaException;
import br.com.micael.cli.menu.Menu;
import br.com.micael.cli.enums.*;

// Java Utils
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.*;

public class MainCLI {
    public static void main(String[] args) {

        // Objetos principais
        Banco banco = new Banco();
        Menu menu = new Menu();

        // Variáveis auxiliares - Banco
        String nomeDoBanco;

        // Variáveis auxiliares - ContaCorrente
        String titular;
        String CPF;
        String senha;
        double saldoInicial;

        // Variáveis auxiliares - Menu
        int op;

        menu.saudações();

        boolean primeiraVisita = true;
        while (true) {

            try {

                if (primeiraVisita) {
                    menu.print("Antes de prosseguir, digite o nome do banco: ");
                    nomeDoBanco = inputStr();
                    banco.setBankName(nomeDoBanco);
                    primeiraVisita = false;
                }

                menu.exibirMenuBanco( banco.getBankName() );

                op = inputInt();

                menu.setOpção( op );

                OpçõesDoMenuBanco opçãoBanco = OpçõesDoMenuBanco.values()[menu.getOpção()];

                out.println("---");
                switch (opçãoBanco) {

                    case ALTERAR_NOME_DO_BANCO:
                        menu.print("Digite o novo nome do banco: ");
                        nomeDoBanco = inputStr();
                        banco.setBankName(nomeDoBanco);
                        break;

                    case CADASTRAR_CONTA_CORRENTE:
                        menu.print("Digite o nome do titular: ");
                        titular = inputStr();
                        menu.print("Digite o CPF do titular: ");
                        CPF = inputStr();
                        menu.print("Digite a senha: ");
                        senha = inputStr();
                        menu.print("Digite o depósito inicial: R$");
                        saldoInicial = inputDouble();

                        if (banco.adicionaConta(new ContaCorrente(titular, CPF, senha, saldoInicial))) {
                            menu.println("Conta criada com sucesso!");
                        }

                        break;

                    case EDITAR_CONTA_CORRENTE:
                        // ...
                        break;

                    case REALIZAR_OPERACOES_EM_CONTA_CORRENTE:

                        menu.print("Digite o número da conta: ");
                        int número = inputInt();
                        if (!banco.existeConta(número)) {
                            menu.println("Conta não encontrada!");
                            break;
                        }

                        boolean sairDoMenuContaCorrente = false;

                        while (!sairDoMenuContaCorrente) {

                            try {
                                menu.exibirMenuContaCorrente(número);
                                menu.setOpção(inputInt());

                                OpçõesDoMenuContaCorrente opçãoContaCorrente = OpçõesDoMenuContaCorrente.values()[menu.getOpção()];

                                switch (opçãoContaCorrente) {

                                    case SAQUE:
                                        menu.println("Realizando saque...");
                                        break;

                                    case DEPOSITO:
                                        menu.println("Realizando depósito...");
                                        break;

                                    case SALDO:
                                        menu.println("Verificando saldo...");
                                        break;

                                    case EXTRATO:
                                        menu.println("Verificando extrato...");
                                        break;

                                    case VOLTAR:
                                        sairDoMenuContaCorrente = true;
                                        break;

                                    case SAIR:
                                        SAIR();
                                }

                            } catch (OpçãoInválidaException oie) {
                                menu.println("Opção inválida! Tente de novo.");
                            }
                        }

                        break;

                    case EXIBIR_CONTAS_CADASTRADAS:
                        if (banco.quantidadeDeContas() > 0) {
                            banco.getListaDeContasCorrente().forEach(out::println);
                        } else {
                            menu.println("Ainda não existem contas cadastradas no banco!");
                        }
                        break;

                    case EXIBIR_DADOS_BANCO:
                        menu.println("Nome do Banco: " + banco.getBankName());
                        menu.println("Quantidade de Contas Cadastradas: " + banco.quantidadeDeContas());
                        break;

                    case EXIBIR_DADOS_CONTA:
                        menu.println("Exibindo dados...");
                        break;

                    case SAIR:
                        SAIR();
                }

            } catch (OpçãoInválidaException oie) {
                err.println("Opção inválida! Tente de novo.");

            } catch (InputMismatchException ime) {
                err.println("...");

            } catch (NomeInválidoException nie) {
                err.println("O nome do banco não pode ficar em branco!");

            } catch (NumberFormatException nfe) {
                err.println("Você deve digitar apenas números!");

            }

        }
    }

    public static int inputInt() {
        Scanner input = new Scanner(in);
        return input.nextInt();
    }

    public static String inputStr() {
        Scanner input = new Scanner(in);
        return input.nextLine();
    }

    public static double inputDouble() {
        Scanner input = new Scanner(in);
        return input.nextDouble();
    }

    private static void SAIR() {
        out.println("Saindo do programa. Volte sempre!");
        exit(0);
    }
}
