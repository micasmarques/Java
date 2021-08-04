package br.com.micael.cliente;

import br.com.micael.interfaces.ObjetoRemotoSignos_IF;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Cliente {
    private static ObjetoRemotoSignos_IF stub;
    private static Registry registry;

    public void executarCliente(String host, String umSigno) {
        try {
            registry = LocateRegistry.getRegistry(host);
            stub = (ObjetoRemotoSignos_IF) registry.lookup("Frase do Signo");
            String resposta = stub.getMensagemSigno(umSigno);
            System.out.println("Frase do signo " + umSigno + ": " + resposta);
        } catch (Exception e) {
            System.err.println("Erro no cliente: " + e.toString());
            e.printStackTrace();
        }
    }
}
