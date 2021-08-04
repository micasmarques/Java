// 3. O  sistema  de  avaliação  de  determinada  disciplina,  é  composto  por  três  provas.  
// A primeira prova tem peso 2, asegunda tem peso 3 e a terceira tem peso 5. 
// Faça um programa em Java para calcular a média final de um aluno desta disciplina.

import java.util.Scanner;

public class Lista01_03 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        
        float n1, n2, n3, media;
        int peso1 = 2, peso2 = 3, peso3 = 5;
        System.out.printf("Digite a nota da primeira prova: ");
        n1 = input.nextFloat();
        System.out.printf("Digite a nota da segunda prova: ");
        n2 = input.nextFloat();
        System.out.printf("Digite a nota da terceira prova: ");
        n3 = input.nextFloat();

        media = ( (n1*peso1) + (n2*peso2) + (n3*peso3) ) / (peso1 + peso2 + peso3);

        System.out.printf("Sua m\351dia final \351: %.1f", media);
    }
}

/* Exemplo de saída:
 *
 * Digite a nota da primeira prova: 7
 * Digite a nota da segunda prova: 9
 * Digite a nota da terceira prova: 5
 * Sua média final é: 6,6
 * 
 * */