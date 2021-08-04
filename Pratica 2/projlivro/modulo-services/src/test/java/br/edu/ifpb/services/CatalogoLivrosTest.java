package br.edu.ifpb.services;

import br.edu.ifpb.livro.Categoria;
import br.edu.ifpb.livro.Livro;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class CatalogoLivrosTest {

    @Test
    public void adicionarLivro() {
        CatalogoLivros MyBookRack = new CatalogoLivros();
        Assert.assertTrue(MyBookRack.catalogoVazio());

        Assert.assertTrue(
                MyBookRack.adicionarLivro(
                        new Livro (
                                "Título",
                                "Guilherme",
                                Categoria.valueOf("Terror".toUpperCase()),
                                750,
                                new Date()
                        )
                )
        );

        Assert.assertFalse(
                MyBookRack.adicionarLivro(
                        new Livro (
                                "Título",
                                "Guilherme",
                                Categoria.valueOf("Terror".toUpperCase()),
                                750,
                                new Date()
                        )
                )
        );

        MyBookRack.limparCatalogo();
    }

    @Test
    public void pesquisarLivroPorTítulo() {
        CatalogoLivros MyBookRack = new CatalogoLivros();

        Assert.assertFalse(MyBookRack.removerLivroPorTítulo("Exemplo"));

        Assert.assertTrue(
                MyBookRack.adicionarLivro(
                        new Livro (
                                "Título",
                                "Guilherme",
                                Categoria.valueOf("Terror".toUpperCase()),
                                750,
                                new Date()
                        )
                )
        );

        Assert.assertEquals(1, MyBookRack.pesquisarLivroPorTítulo("Título"));

        Assert.assertTrue(MyBookRack.removerLivroPorTítulo("Título"));

        Assert.assertEquals(-1, MyBookRack.pesquisarLivroPorTítulo("Título"));

        MyBookRack.limparCatalogo();
    }

    @Test
    public void removerLivroPorTítulo() {
        CatalogoLivros MyBookRack = new CatalogoLivros();

        Assert.assertFalse(MyBookRack.removerLivroPorTítulo("Exemplo"));

        Assert.assertTrue(
                MyBookRack.adicionarLivro(
                        new Livro (
                                "Título",
                                "Guilherme",
                                Categoria.valueOf("Drama".toUpperCase()),
                                1502.56,
                                new Date()
                        )
                )
        );

        Assert.assertEquals(1, MyBookRack.pesquisarLivroPorTítulo("Título"));

        Assert.assertTrue(MyBookRack.removerLivroPorTítulo("Título"));

        Assert.assertEquals(-1, MyBookRack.pesquisarLivroPorTítulo("Título"));

        MyBookRack.limparCatalogo();
    }

    @Test
    public void catalogoVazio() {
        CatalogoLivros MyBookRack = new CatalogoLivros();
        Assert.assertTrue(MyBookRack.catalogoVazio());

        String categoria = "Comedia";
        Livro novoLivro = new Livro (
                "Exemplo",
                "Guilherme",
                Categoria.valueOf(categoria.toUpperCase()),
                225.33,
                new Date()
        );

        Assert.assertTrue(MyBookRack.adicionarLivro(novoLivro));
        Assert.assertFalse(MyBookRack.catalogoVazio());

        MyBookRack.limparCatalogo();
        Assert.assertTrue(MyBookRack.catalogoVazio());
    }

    @Test
    public void limparCatalogo() {
        CatalogoLivros MyBookRack = new CatalogoLivros();
        Assert.assertTrue(MyBookRack.catalogoVazio());

        Assert.assertTrue(
                MyBookRack.adicionarLivro(
                        new Livro (
                                "Título",
                                "Guilherme",
                                Categoria.valueOf("Terror".toUpperCase()),
                                750,
                                new Date()
                        )
                )
        );
        Assert.assertTrue(
                MyBookRack.adicionarLivro(
                        new Livro (
                                "Exemplo",
                                "Guilherme",
                                Categoria.valueOf("Drama".toUpperCase()),
                                200,
                                new Date()
                        )
                )
        );
        Assert.assertFalse(MyBookRack.catalogoVazio());

        MyBookRack.limparCatalogo();
        Assert.assertTrue(MyBookRack.catalogoVazio());
    }
}