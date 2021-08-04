// 5. Crie um programa em Java para receber um número entre 1 e 12 e imprimir o nome do mês correspondente 
// (em que, 1 –Janeiro e 12 –Dezembro).
// Crie um método em Java que deverá receber o número e realizar a impressão.

import java.util.Scanner;

class NomeMes {

    public void imprimir(int n) {
        if( n == 1 ) {
            System.out.println("Janeiro");
        } else if ( n == 2 ) {
            System.out.println("Fevereiro");
        } else if ( n == 3 ) {
            System.out.println("Mar\347o");
        } else if ( n == 4 ) {
            System.out.println("Abril");
        } else if ( n == 5 ) {
            System.out.println("Maio");
        } else if ( n == 6 ) {
            System.out.println("Junho");
        } else if ( n == 7 ) {
            System.out.println("Julho");
        } else if ( n == 8 ) {
            System.out.println("Agosto");
        } else if ( n == 9 ) {
            System.out.println("Setembro");
        } else if ( n == 10 ) {
            System.out.println("Outubro");
        } else if ( n == 11 ) {
            System.out.println("Novembro");
        } else if ( n == 12 ) {
            System.out.println("Dezembro");
        } else {
            System.out.println("M\352s inv\341lido.");
        }
    }
}

public class Lista01_05 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        NomeMes nomeMes = new NomeMes();

        int n;
        System.out.printf("Digite o n\372mero do m\352s: ");
        n = input.nextInt();
        nomeMes.imprimir(n);
    }
}
