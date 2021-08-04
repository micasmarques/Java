package br.edu.ifpb;

import org.junit.Assert;
import org.junit.Test;

public class CalculadoraTest
{
    @Test
    public void sum() {

        Calculadora calculadora = new Calculadora();

        // Using the method
        double sum = calculadora.somar(25, 45);

        // Testing General Running
        calculadora.gravarMemoria(sum);
        Assert.assertEquals(25+45, calculadora.lerMemoria(), 0);
    }

    @Test
    public void subtract() {

        Calculadora calculadora = new Calculadora();

        // Using the method
        double subtraction = calculadora.subtrair(45, 25);

        // Testing General Running
        calculadora.gravarMemoria(subtraction);
        Assert.assertEquals(45-25, calculadora.lerMemoria(), 0);
    }

    @Test
    public void multiply() {

        Calculadora calculadora = new Calculadora();

        // Using the method
        double multiplication = calculadora.multiplicar(10, 25);

        // Testing General Running
        calculadora.gravarMemoria(multiplication);
        Assert.assertEquals(10*25, calculadora.lerMemoria(), 0);

    }

    @Test
    public void divide() {

        Calculadora calculadora = new Calculadora();

        // Using the method
        double division = calculadora.dividir(100, 10);

        // Testing General Running
        calculadora.gravarMemoria(division);
        Assert.assertEquals(10, calculadora.lerMemoria(), 0);
    }

    @Test
    public void aboutDescription() {

        Calculadora calculadora = new Calculadora();

        // Testing General Running
        calculadora.alterarDescricao("Testing");
        Assert.assertEquals("Testing", calculadora.consultarDescricao());
    }

}
