// 6.Um hotel cobra R$ 60.00 a diária e mais uma taxa de serviços. 
// A taxa de serviços é de:
// •R$ 5.50 por diária, se o número de diárias for maior que 15;
// •R$ 6.00 por diária, se o número de diárias for igual a 15;
// •R$ 8.00 por diária, se o número de diárias for menor que 15.
// •Construa  um programa  Java que  mostre  o  nome  e  o  total  da  conta  de  um cliente.
import java.util.Calendar;
import java.util.Scanner;

public class Lista01_06 {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        Scanner input = new Scanner(System.in);

        String nome;
        int diarias;
        int hora = cal.get(Calendar.HOUR_OF_DAY);
        double diaria = 60.00;
        double total = 0;

        System.out.printf("Informe seu nome: ");
        nome = input.nextLine();
        System.out.printf("Informe quantas di\341rias: ");
        diarias = input.nextInt();
        
        if( diarias >= 15 ) {
            total += (diaria*diarias) + (5.5*diarias);
        } else if ( diarias == 15 ) {
            total += (diaria*diarias) + (6.0*diarias);
        } else if ( diarias < 15 ) {
            total += (diaria*diarias) + (8.0*diarias);
        }

        System.out.printf("Ol\341 %s", nome);
        if (hora > 1 && hora < 12){
            System.out.println(", Bom Dia!");
        } else if (hora >= 12 && hora <= 18){
            System.out.println(", Boa Tarde!");
        } else {
            System.out.println(", Boa Noite!");
        }
        System.out.printf("Sua conta totalizou: R$%.2f", total);
    }
}
