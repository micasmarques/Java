package br.edu.ifpb.livro;

public enum Categoria {
    COMEDIA("Comedia"),
    DRAMA("Drama"),
    FANTASIA("Fantasia"),
    ROMANCE("Romance"),
    TERROR("Terror");

    private final String nomeCategoria;

    private Categoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    @Override
    public String toString() {
        return nomeCategoria;
    }

}
