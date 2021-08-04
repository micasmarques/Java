package br.ifpb.edu.entities;

import org.junit.Assert;
import org.junit.Test;

public class FuncionárioTest {

    @Test
    public void getNome() {
        Funcionário funcionário = new Funcionário("Nome", 18, "Rua Tal", 980.00);
        Assert.assertEquals("Nome", funcionário.getNome());
    }

    @Test
    public void setNome() {
        Funcionário funcionário = new Funcionário();
        funcionário.setNome("Nome tal");
        Assert.assertEquals("Nome tal", funcionário.getNome());

        funcionário.setNome("");
        Assert.assertEquals("Nome tal", funcionário.getNome());
    }

    @Test
    public void getMatrícula() {
        Funcionário funcionário = new Funcionário("Nome", 18, "Rua Tal", 980.00);
    }

    @Test
    public void getIdade() {
        Funcionário funcionário = new Funcionário("Nome", 18, "Rua Tal", 980.00);
        Assert.assertEquals(18, funcionário.getIdade());
    }

    @Test
    public void setIdade() {
        Funcionário funcionário = new Funcionário();
        funcionário.setIdade( 21 );
        Assert.assertEquals(21, funcionário.getIdade());

        funcionário.setIdade( -1 );
        Assert.assertEquals(21, funcionário.getIdade());
    }

    @Test
    public void getEndereço() {
        Funcionário funcionário = new Funcionário("Nome", 18, "Rua Tal", 980.00);
        Assert.assertEquals("Rua Tal", funcionário.getEndereço());
    }

    @Test
    public void setEndereço() {
        Funcionário funcionário = new Funcionário();
        funcionário.setEndereço("Novo End");
        Assert.assertEquals("Novo End", funcionário.getEndereço());

        funcionário.setEndereço("");
        Assert.assertEquals("Novo End", funcionário.getEndereço());
    }

    @Test
    public void getSalárioBase() {
        Funcionário funcionário = new Funcionário("Nome", 18, "Rua Tal", 980.00);
        Assert.assertEquals(980.00, funcionário.getSalárioBase(), 0);
    }

    @Test
    public void setSalárioBase() {
        Funcionário funcionário = new Funcionário();
        funcionário.setSalárioBase( 500 );
        Assert.assertEquals(500, funcionário.getSalárioBase(), 0);

        funcionário.setSalárioBase( -1 );
        Assert.assertEquals(500, funcionário.getSalárioBase(), 0);
    }

    @Test
    public void formatoMoeda() {
        double valor = 980.00;
        Funcionário funcionário = new Funcionário();
        Assert.assertEquals("R$ 980,00", funcionário.formatoMoeda(valor));
    }
}