package br.com.micael.cliente;

import java.util.Scanner;

public class MainCliente {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Digite o IP do servidor: ");
        String host = input.nextLine();

        System.out.print("Digite o signo: ");
        String umSigno = input.nextLine();

        System.out.println("Aguarde. Contatando o servidor...");

        Cliente cliente = new Cliente();
        cliente.executarCliente(host, umSigno);

        input.close();
    }
}
