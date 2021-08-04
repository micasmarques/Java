package br.edu.ifpb;

import java.util.Scanner;

class MenuCalculadora
{
    private Calculadora calculadora = new Calculadora();

    void exibirMenu() {

        calculadora.alterarDescricao("Calculadora do Gui!. :)");

        while (true)
        {

            Scanner input = new Scanner( System.in );

            System.out.print(   "Calculadora \n" +
                                "================\n" +
                                "   1. Somar\n" +
                                "   2. Subtrair\n" +
                                "   3. Multiplicar\n" +
                                "   4. Dividr\n" +
                                "   5. Sobre a Calculadora\n" +
                                "   6. Sair\n" +
                                "   Digite uma opção:_");

            // ler com scanner a opção
            int opcao = input.nextInt();
            double[] numeros = {1, 2};

            if (opcao < 5) numeros = capturarNumeros();

            switch (opcao)
            {
                case 1:
                    // Somar
                    double soma = calculadora.somar(numeros[0], numeros[1]);
                    System.out.println("A adição de " + numeros[0] + " com " + numeros[1] + " é: " + soma);
                    break;

                case 2:
                    // Subtrair
                    double subtracao = calculadora.subtrair(numeros[0], numeros[1]);
                    System.out.println("A diferença de " + numeros[0] + " e " + numeros[1] + " é: " + subtracao);
                    break;

                case 3:
                    // Multiplicar
                    double multiplicacao = calculadora.multiplicar(numeros[0], numeros[1]);
                    System.out.println("O produto de " + numeros[0] + " por " + numeros[1] + " é: " + multiplicacao);
                    break;

                case 4:
                    // Dividir
                    double divisao = calculadora.dividir(numeros[0], numeros[1]);
                    System.out.println("A divisão de " + numeros[0] + " e " + numeros[1] + " é: " + divisao);
                    break;

                case 5:
                    // Exibir descrição
                    System.out.println(calculadora.consultarDescricao());
                    break;

                case 6:
                    // Sair
                    System.out.println("Saindo.");
                    break;

                case 10:
                    // Opção secreta, setar descrição
                    System.out.print("Digite a descricao da calculadora: ");
                    input.nextLine();
                    String desc = input.nextLine();
                    calculadora.alterarDescricao(desc);
                    break;

                default:
                    // Opcao invalida
                    System.out.println("Opcao Invalida.");
                    break;
            }

            boolean continua = true;

            System.out.print(   "Deseja continuar? \n" +
                                "   1. Sim \n" +
                                "   0. Nao \n");

            while (true) {
                int escolha = input.nextInt();
                if ( escolha == 0 ) {
                    System.out.println("Saindo");
                    continua = false;
                    break;
                } else if ( escolha == 1 ) {
                    System.out.println();
                    break;
                } else {
                    System.out.println( "Escolha invalida. Escolha de novo: \n" +
                                        "   1. Sim \n" +
                                        "   0. Nao \n");
                }
            }

            if (!continua) {
                input.close();
                break;
            }
        }
    }

    private double[] capturarNumeros() {
        double [] temp = new double[2];
        Scanner input = new Scanner( System.in );
        System.out.println("Obs.: Use virgula como separador de decimais.");
        System.out.print("Digite o primeiro número: ");
        temp[0] = input.nextDouble();
        System.out.print("Digite o segundo número: ");
        temp[1] = input.nextDouble();
        return temp;
    }

}
