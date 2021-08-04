package br.com.micael.conta.exceptions;

public class IgualAZeroException extends RuntimeException {
    public IgualAZeroException() {
        this("Erro! Quantia igual a zero!");
    }

    public IgualAZeroException(String messagem) {
        super(messagem);
    }
}
