package br.com.guilherme.banco.exceptions;

public class NomeInválidoException extends RuntimeException {
    public NomeInválidoException() {
        this("Erro! Nome inválido!");
    }

    public NomeInválidoException(String msg) {
        super(msg);
    }
}
