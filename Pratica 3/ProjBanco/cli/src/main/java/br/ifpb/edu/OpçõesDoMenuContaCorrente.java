package br.ifpb.edu;

public enum OpçõesDoMenuContaCorrente {
    SAQUE("Sacar"),
    DEPOSITO("Depositar"),
    SALDO("Saldo na tela"),
    EXTRATO("Extrato na tela"),
    SAIR("SAIR");

    private final String nomeOpção;

    OpçõesDoMenuContaCorrente(String nomeOpção) {
        this.nomeOpção = nomeOpção;
    }

    @Override
    public String toString() {
        return nomeOpção;
    }
}
