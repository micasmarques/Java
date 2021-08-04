package br.com.micael.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ObjetoRemotoSignos_IF extends Remote {
    String getMensagemSigno(String umSigno) throws RemoteException;
}
