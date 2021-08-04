package br.edu.ifpb.gui.texto;

import br.edu.ifpb.conversor.Conversor;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {

        Conversor conversor = new Conversor();

        System.out.println("|Bem Vindo ao Conversor DECIMAL -> HEXADECIMAL/BINÁRIO|");
        while (true) {

            System.out.print("Digite o número decimal a ser convertido:__");
            int valorDecimal = inputInt();

            int op;

            System.out.println("Agora digite a opção:");
            while (true) {
                System.out.print(
                        "1. Para Hexadecimal" + "\n" +
                        "2. Para Binário" + "\n" +
                        "3. SAIR" + "\n" +
                        " Opção:__"
                );

                op = inputInt();

                if (op < 1 || op > 3) {
                    System.out.println("Opção inválida!\nEscolha novamente.");
                } else {
                    break;
                }
            }

            separador();
            switch (op) {
                case 1:
                    System.out.println("Valor convertido para Hexadecimal: " + conversor.decimalParaHexadecimal(valorDecimal));
                    break;

                case 2:
                    System.out.println("Valor convertido para Binário: " + conversor.decimalParaBinário(valorDecimal));
                    break;

                case 3:
                    System.out.println("Saindo...");
                    System.exit(0);
            }
            separador();

        }
    }

    private static int inputInt() {
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }

    private static void separador() {
        System.out.println("---");
    }
}
