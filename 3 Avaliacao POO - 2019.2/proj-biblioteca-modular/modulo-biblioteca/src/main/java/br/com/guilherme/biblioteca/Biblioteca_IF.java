package br.com.guilherme.biblioteca;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Biblioteca_IF extends Remote {
    String buscarLivro(String ID) throws RemoteException;
    String cadastrarLivro(String ID, String titulo, String autor, String tipo, String preco) throws RemoteException;
    String removerLivro(String ID) throws RemoteException;
}
