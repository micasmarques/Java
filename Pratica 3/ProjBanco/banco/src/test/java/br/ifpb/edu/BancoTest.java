package br.ifpb.edu;

import org.junit.Assert;
import org.junit.Test;


public class BancoTest {

    @Test
    public void getBankName() {
        Banco bank = new Banco("Exemplo");
        Assert.assertEquals("Exemplo", bank.getBankName());

        bank.setBankName("");
        Assert.assertEquals("Exemplo", bank.getBankName());
    }

    @Test
    public void setBankName() {
        Banco semNome = new Banco();
        Assert.assertEquals("--- Banco Sem Nome ---", semNome.getBankName());

        semNome.setBankName("Novo Nome");
        Assert.assertEquals("Novo Nome", semNome.getBankName());
    }

    @Test
    public void adicionaConta() {
        Banco bank = new Banco("Exemplo");
        boolean adicionou = false;

        adicionou = bank.adicionaConta(
                new ContaCorrente(1, "Exe", 100)
        );

        Assert.assertTrue(adicionou);
    }

    @Test
    public void removeConta() {
        Banco bank = new Banco("Exemplo");
        ContaCorrente cc = new ContaCorrente(1, "Exe", 100);

        bank.adicionaConta(cc);

        boolean removeu = false;
        removeu = bank.removeConta(1);

        Assert.assertTrue(removeu);
    }

    @Test
    public void existeConta() {
        Banco bank = new Banco("Exemplo");
        ContaCorrente cc = new ContaCorrente(1, "Exe", 100);
        bank.adicionaConta(cc);

        Assert.assertTrue(bank.existeConta(1));
    }

    @Test
    public void quantidadeDeContas() {
        Banco bank = new Banco("Exemplo");
        ContaCorrente cc = new ContaCorrente(1, "Exe", 100);
        bank.adicionaConta(cc);

        Assert.assertEquals(1, bank.quantidadeDeContas(), 0);
    }

    @Test
    public void getListaDeContasCorrente() {
    }

    @Test
    public void testToString() {

        StringBuilder str = new StringBuilder();

        str.append("|Banco Exemplo|" + "\n");

    }
}