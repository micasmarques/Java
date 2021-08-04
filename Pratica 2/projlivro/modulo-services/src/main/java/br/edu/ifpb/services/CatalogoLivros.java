package br.edu.ifpb.services;

import br.edu.ifpb.livro.Livro;

import java.util.ArrayList;

public class CatalogoLivros {

    private ArrayList<Livro> listaDeLivros;

    public CatalogoLivros() {
        this.listaDeLivros = new ArrayList<>();
    }

    public ArrayList<Livro> getListaDeLivros() {
        return listaDeLivros;
    }

    public boolean adicionarLivro(Livro livro) {

        if (this.pesquisarLivroPorTítulo(livro.getTítulo()) > 0) return false;

        this.listaDeLivros.add(livro);
        return true;
    }

    public boolean removerLivro(int código) {

        for (Livro livro : listaDeLivros) {
            if (livro.getCódigo() == código) {
                listaDeLivros.remove(livro);
                return true;
            }
        }

        return false;
    }

    public boolean removerLivroPorTítulo(String título) {

        for (Livro livro: listaDeLivros) {
            if (livro.getTítulo().equals(título)) {
                listaDeLivros.remove(livro);
                return true;
            }
        }

        return false;
    }

    public boolean pesquisarLivro(int código) {

        for (Livro livro : listaDeLivros) {
            if (livro.getCódigo() == código) {
                return true;
            }
        }

        return false;
    }

    public int pesquisarLivroPorTítulo(String título) {

        for (Livro livro : listaDeLivros) {
            if (livro.getTítulo().equals(título)) {
                return livro.getCódigo();
            }
        }

        return -1;
    }

    public boolean catalogoVazio() {
        return this.listaDeLivros.isEmpty();
    }

    public String listarLivros() {

        StringBuilder catalogo = new StringBuilder();

        for (Livro livro : listaDeLivros) {
            catalogo.append(livro.toString()).append("\n");
        }

        return catalogo.toString();
    }

    public void limparCatalogo() {
        this.listaDeLivros.clear();
        Livro.setINCREMENTADOR(0);
    }
}
