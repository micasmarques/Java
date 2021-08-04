package br.com.micael.cli.enums;

public enum OpçõesDoMenuContaCorrente {
    SAQUE("Sacar"),
    DEPOSITO("Depositar"),
    SALDO("Saldo na tela"),
    EXTRATO("Extrato na tela"),
    VOLTAR("Voltar"),
    SAIR("SAIR DO PROGRAMA");

    private final String nomeOpção;

    OpçõesDoMenuContaCorrente(String nomeOpção) {
        this.nomeOpção = nomeOpção;
    }

    @Override
    public String toString() {
        return nomeOpção;
    }
}
