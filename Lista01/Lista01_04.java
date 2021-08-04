// 4. Crie um programa Java para verificar se o aluno foi aprovado (média maior ou igual a 7,0),
// se vai fazer final (média maior ou igual a 5,0 e menor do que 7,0) ou se foi reprovado (média abaixo de 5,0).
// O usuário deverá informar 4 notas.

import java.util.Scanner;

public class Lista01_04 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        float n1, n2, n3, n4, media;
        System.out.printf("Informe sua primeira nota: ");
        n1 = input.nextFloat();
        System.out.printf("Informe sua segunda nota: ");
        n2 = input.nextFloat();
        System.out.printf("Informe sua terceira nota: ");
        n3 = input.nextFloat();
        System.out.printf("Informe sua quarta nota: ");
        n4 = input.nextFloat();

        media = (n1 + n2 + n3 + n4) /4;

        System.out.printf("Sua m\351dia foi: %.1f", media);
        System.out.printf(", e voc\352 est\341 ");
        if( media >= 7 ) {
            System.out.printf("aprovado!");
        } else if ( media >= 5 && media < 7 ) {
            System.out.printf("na final!");
        } else if ( media < 5 ) {
            System.out.printf("reprovado!");
        }

    }
}
