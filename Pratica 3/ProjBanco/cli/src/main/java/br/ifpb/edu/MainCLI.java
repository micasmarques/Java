package br.ifpb.edu;

import java.util.Scanner;

public class MainCLI {
    public static void main(String[] args) {

        Banco banco = new Banco();
        Menu menu = new Menu();

        menu.saudações();
        banco.setBankName(MainCLI.inputString());

        while (true) {

            while (true) {
                menu.exibirMenuBanco(banco.getBankName());
                menu.setOpção(MainCLI.inputInt());

                if (menu.getOpção() < 0 || menu.getOpção() > OpçõesDoMenuBanco.values().length) {
                    System.out.println("Opção inválida!");
                } else {
                    break;
                }
            }

            OpçõesDoMenuBanco opçãoBanco = OpçõesDoMenuBanco.values()[menu.getOpção()];

            switch (opçãoBanco) {

                case ALTERAR_NOME_DO_BANCO:
                    System.out.println("Alterar dados");
                    break;

                case SAIR:
                    System.out.println("Saindo...");
                    System.exit(0);

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
}
