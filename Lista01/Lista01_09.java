// 9.Crie  um programa  Java que  receba  dois  números  do  usuário  e  que  mostre  a quantidade de números pares, 
// a quantidade de números ímpares e a soma entre os dois números informados.

import java.util.Scanner;

public class Lista01_09 {
    public static void main(String[] args) {
        int[] nums = new int[2];
        int pares=0, impares=0, soma=0;

        Scanner input = new Scanner(System.in);

        System.out.printf("Informe o in\355cio do intervalo: ");
        nums[0] = input.nextInt();
        System.out.printf("Informe o fim do intervalo: ");
        nums[1] = input.nextInt();

        for(int i = nums[0]; i <= nums[1]; i++) {
            soma += i;
            if( i % 2 == 0 ) {
                pares++;
            } else { impares++; }
        }

        System.out.println("Quantidade de pares: "+ pares);
        System.out.println("Quantidade de \355mpares: "+ impares);
        System.out.println("Soma entre os dois n\372meros informados: "+ soma);
    }
}
