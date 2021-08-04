// 2.Crie um programa Java que determine a idade atual da pessoa, baseado no ano de nascimento. //

import java.util.Calendar;
import java.util.Scanner;

public class Lista01_02 {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        int ano_atual = cal.get(Calendar.YEAR);

        Scanner input = new Scanner(System.in);
        
        int ano_nascimento, idade;
        System.out.printf("Digite seu ano de nascimento: ");
        ano_nascimento = input.nextInt();
        idade = ano_atual - ano_nascimento;
        System.out.println( "Considerando que voc\352 nasceu em " + ano_nascimento +
                            " e n\363s estamos em " + ano_atual +
                            ", este ano voc\352 far\341: \n" + idade + " anos");
    }
}

/* Exemplo de saída:
 *
 * Digite seu ano de nascimento: 1997
 * Considerando que você nasceu em 1997 e nós estamos em 2019, este ano você fará:
 * 22 anos
 * 
 * */