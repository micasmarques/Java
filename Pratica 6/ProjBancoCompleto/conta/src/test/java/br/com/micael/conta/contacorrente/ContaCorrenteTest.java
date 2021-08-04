package br.com.micael.conta.contacorrente;

import br.com.micael.conta.exceptions.QuantiaNegativaException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;


@FixMethodOrder(MethodSorters.NAME_ASCENDING) // Testes são realizados por ordem alfabética
public class ContaCorrenteTest {

    @Test // Deve rodar este teste primeiro pois o nome do método inicia com a letra "a"
    public void a_getNúmero() {
        ContaCorrente cc = new ContaCorrente("Teste", "12345678912", "123", 150);

        // Para funcionar: certificar-se de ser o primeiro teste a ser rodado
        Assert.assertEquals(1, cc.getNúmero());
    }

    @Test
    public void getTitular() {
        ContaCorrente cc = new ContaCorrente("Guilherme", "12345678915", "123", 100);
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
        ContaCorrente cc = new ContaCorrente("Gui", "12345678918", "123", 255);
        Assert.assertEquals(255, cc.getSaldo(), 0);
    }

    @Test(expected = QuantiaNegativaException.class)
    public void setSaldo() {
        ContaCorrente cc = new ContaCorrente();
        cc.setSaldo( 1200 );
        Assert.assertEquals(1200, cc.getSaldo(), 0);
        cc.setSaldo( -100 );
        Assert.assertEquals(1200, cc.getSaldo(), 0);
    }

    @Test(expected = QuantiaNegativaException.class)
    public void depositar() {
        ContaCorrente cc = new ContaCorrente("Gui", "12345678925", "123", 250);

        cc.depositar(1250);
        Assert.assertEquals(1500, cc.getSaldo(), 0);

        double saldoAnterior = cc.getSaldo();

        cc.depositar( -1 );
        Assert.assertEquals(saldoAnterior, cc.getSaldo(), 0);
    }

    @Test(expected = QuantiaNegativaException.class)
    public void sacar() {
        ContaCorrente c3 = new ContaCorrente("Gui", "12345678927", "123", 1000);

        double dinheiroSacado = c3.sacar(100);
        Assert.assertEquals(899, c3.getSaldo(), 0);
        Assert.assertEquals(100, dinheiroSacado, 0);

        c3.sacar(-100);
        Assert.assertEquals(899, c3.getSaldo(), 0);
    }

//    @Test
//    public void testToString() {
//        String str = "|Dados da Conta 1|" + "\n" +
//                "Titular: Exemplo" + "\n" +
//                "Saldo: R$ 500,00";
//
//        ContaCorrente cc = new ContaCorrente(1, "Exemplo", 500, new Date());
//
//        Assert.assertEquals(str, cc.toString());
//    }

}