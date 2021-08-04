package br.com.guilherme.servidor;

import br.com.guilherme.biblioteca.*;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Servidor {
    public static void main(String[] args) {

        try {
            System.out.println("> Conectando Servidor...");
            Biblioteca obj = new Biblioteca();
            Biblioteca_IF stub = (Biblioteca_IF) UnicastRemoteObject.exportObject(obj, 0);

            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("biblioteca", stub);

            System.out.println("> Servidor da Biblioteca RMI pronta!");
            System.out.println("> Aguardando Cliente...");

        } catch (Exception e) {
            System.out.println("Erro no Servidor: " + e.toString());
            e.printStackTrace();
        }

    }
}
