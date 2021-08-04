// 10.Faça um programa Javaque leia um número e divida-o por dois (sucessivamente) 
// até  que  o  resultado  seja  menor  que  1.  Mostre  o  resultado  da  última  
// divisão  e  a quantidade de divisões efetuadas.

import java.util.Scanner;

public class Lista01_10 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        float numero;
        int cont = 0;

        System.out.printf("Informe um numero: ");
        numero = input.nextFloat();

        while(true){
            numero/=2;
            cont ++;
            if (numero < 1){
                break;
            }   
        }

        System.out.printf("Resultado final: %.2f\n Divis\365es efetuadas: %d\n", numero, cont);

    }
} 