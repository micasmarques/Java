package br.com.guilherme.biblioteca;

import org.junit.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

public class BibliotecaTest {

    private Biblioteca biblioteca = new Biblioteca();

    @Test
    public void buscarLivro() {

        String encontrado = "Livro encontrado!" +
                "\n|Dados|" +
                "\nID: 12" +
                "\nTítulo: More Fun with Rat and Goose" +
                "\nAutor: Richard Luke" +
                "\nTipo: paperback" +
                "\nPreço: 12.99";

        assertThat( biblioteca.buscarLivro("12" ), is( encontrado ));

    }

    @Test
    public void cadastrarLivro() {

        String cadastrado = "Livro foi cadastrado com sucesso";

        assertThat( biblioteca.cadastrarLivro("22", "Teste", "Guilherme", "ebook", "30.00"), is( cadastrado ));

    }

    @Test
    public void removerLivro() {

        String removido = "Livro foi removido com sucesso";

        assertThat( biblioteca.removerLivro("22"), is( removido ));

    }
}