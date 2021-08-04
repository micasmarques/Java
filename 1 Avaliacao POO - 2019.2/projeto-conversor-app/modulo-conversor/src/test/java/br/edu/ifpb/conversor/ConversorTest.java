package br.edu.ifpb.conversor;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConversorTest {

    @Test
    public void decimalParaHexadecimal() {
        Conversor conversor = new Conversor();

        int decimal = 15;
        String Hexa = conversor.decimalParaHexadecimal(decimal);

        Assert.assertEquals("f", Hexa);
    }

    @Test
    public void decimalParaBinário() {
        Conversor conversor = new Conversor();

        int decimal = 4;
        String binário = conversor.decimalParaBinário(decimal);

        Assert.assertEquals("100", binário);
    }
}