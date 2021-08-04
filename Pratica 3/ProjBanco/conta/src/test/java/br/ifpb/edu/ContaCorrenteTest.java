package br.ifpb.edu;

import org.junit.Assert;
import org.junit.Test;

public class ContaCorrenteTest {
    @Test
    public void getNúmero() {
        ContaCorrente cc = new ContaCorrente(1, "Teste", 150);

        Assert.assertEquals(1, cc.getNúmero());
    }

    @Test
    public void setNúmero() {
        ContaCorrente cc = new ContaCorrente();
        cc.setNúmero( 1 );

        Assert.assertEquals(1, cc.getNúmero());

        cc.setNúmero( -1 );
        Assert.assertEquals(1, cc.getNúmero());
    }

    @Test
    public void getTitular() {
        ContaCorrente cc = new ContaCorrente(1, "Guilherme", 100);
        Assert.assertEquals("Guilherme", cc.getTitular());
    }

    @Test
    public void setTitular() {
        ContaCorrente cc = new ContaCorrente();
        cc.setTitular("Gui");
        Assert.assertEquals("Gui", cc.getTitular());
        cc.setTitular("");
        Assert.assertEquals("Gui", cc.getTitular());
    }

    @Test
    public void getSaldo() {
        ContaCorrente cc = new ContaCorrente(1, "Gui", 255);
        Assert.assertEquals(255, cc.getSaldo(), 0);
    }

    @Test
    public void setSaldo() {
        ContaCorrente cc = new ContaCorrente();
        cc.setSaldo( 1200 );
        Assert.assertEquals(1200, cc.getSaldo(), 0);
        cc.setSaldo( -100 );
        Assert.assertEquals(1200, cc.getSaldo(), 0);
    }

    @Test
    public void depositar() {
        ContaCorrente cc = new ContaCorrente(1, "Gui", 250);

        cc.depositar(1250);
        Assert.assertEquals(1500, cc.getSaldo(), 0);

        double saldoAnterior = cc.getSaldo();

        cc.depositar( -1 );
        Assert.assertEquals(saldoAnterior, cc.getSaldo(), 0);
    }

    @Test
    public void sacar() {
        ContaCorrente cc = new ContaCorrente(1, "Gui", 1000);

        double dinheiroSacado = cc.sacar(100);
        Assert.assertEquals(899, cc.getSaldo(), 0);
        Assert.assertEquals(100, dinheiroSacado, 0);

        cc.sacar(-100);
        Assert.assertEquals(899, cc.getSaldo(), 0);
    }

    @Test
    public void testToString() {
        String str = "|Dados da Conta 1|" + "\n" +
                "Titular: Exemplo" + "\n" +
                "Saldo: R$ 500,00";

        ContaCorrente cc = new ContaCorrente(1, "Exemplo", 500);

        Assert.assertEquals(str, cc.toString());
    }
}
