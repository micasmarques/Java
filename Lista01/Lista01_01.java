/* 1.Crie um programa Java para receber uma velocidade em m/s e alterar para km/h. */

import java.util.Scanner;

public class Lista01_01 {

    public static void main(String[] args) {

        Scanner input = new Scanner( System.in );

        double velocidade, kmH;
        System.out.printf("Digite uma velocidade em m/s para convert\352-la em km/h: ");
        velocidade = input.nextDouble();
        kmH = velocidade*3.6;
        System.out.printf("%.2f m/s equivale a: %.2f km/h", velocidade, kmH);

        input.close();
    }

}

/* Saída:
 * Digite uma velocidade em m/s para convertê-la em km/h: 120
 * 120,00 m/s equivale a: 436,00 km/h
 **/