package br.ifpb.edu.universidade;

import br.ifpb.edu.entities.Funcionário;
import org.junit.*;

public class UniversidadeTest {

    @Test
    public void getNome() {
        Universidade universidade = new Universidade("Nome");
        Assert.assertEquals("Nome", universidade.getNome());
    }

    @Test
    public void setNome() {
        Universidade universidade = new Universidade();
        universidade.setNome("Novo Nome");
        Assert.assertEquals("Novo Nome", universidade.getNome());

        universidade.setNome("");
        Assert.assertEquals("Novo Nome", universidade.getNome());
    }

    @Test
    public void existeFuncionário() {
        Universidade universidade = new Universidade();
        Funcionário funcionário = new Funcionário();
        universidade.cadastraFuncionário(funcionário);
        Assert.assertTrue(universidade.existeFuncionário(funcionário.getMatrícula()));
    }

    @Test
    public void cadastraFuncionário() {
        Universidade universidade = new Universidade();
        Funcionário funcionário = new Funcionário();
        Assert.assertTrue(universidade.cadastraFuncionário(funcionário));
        Assert.assertTrue(universidade.existeFuncionário(funcionário.getMatrícula()));
    }

    @Test
    public void removeFuncionário() {
        Universidade universidade = new Universidade();
        Funcionário funcionário = new Funcionário();
        universidade.cadastraFuncionário(funcionário);
        Assert.assertTrue(universidade.removeFuncionário(funcionário.getMatrícula()));
        Assert.assertFalse(universidade.existeFuncionário(funcionário.getMatrícula()));
    }

    @Test
    public void quantidadeDeFuncionários() {
        Universidade universidade = new Universidade();
        universidade.cadastraFuncionário(new Funcionário());
        universidade.cadastraFuncionário(new Funcionário());
        Assert.assertEquals(2, universidade.quantidadeDeFuncionários(), 0);
    }
}