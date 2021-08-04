// 8.Crie um programa Java que peça 10 números inteiros e apresente: a média, o maior e o menor.

import java.util.Scanner;

public class Lista01_08 {
    public static void main(String[] args) {
        int[] nums = new int[10];
        double soma=0, media=0;
        int maior=0, menor=0;

        Scanner input = new Scanner(System.in);

        for(int i=1; i < nums.length+1; i++) {
            System.out.printf("Digite o "+ i +"\260 n\372mero: ");
            nums[i-1] = input.nextInt();
        }

        for(int j=0; j < nums.length; j++) {
            soma += nums[j];
            if( j == 0 || nums[j] >= maior ) {
                maior = nums[j];
            }
            if( j == 0 || nums[j] <= menor ) {
                menor = nums[j];
            }
        }

        media = soma / nums.length;

        System.out.printf("M\351dia: %.2f\n", media);
        System.out.println("Maior: "+ maior);
        System.out.println("Menor: "+ menor);
    }
}
