package br.ifpb.edu.entities.gerente;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class GerenteTest {

    @Test
    public void getGratificação() {
        Gerente gerente = new Gerente("Novo Gerente", 45, "Ger End", 2500, 800);
        Assert.assertEquals(800, gerente.getGratificação(), 0);
    }

    @Test
    public void setGratificação() {
        Gerente gerente = new Gerente();
        gerente.setGratificação( 150 );
        Assert.assertEquals( 150, gerente.getGratificação(), 0);

        gerente.setGratificação( -1 );
        Assert.assertEquals( 150, gerente.getGratificação(), 0);
    }

    @Test
    public void getSalárioBase() {
        Gerente gerente = new Gerente("Novo Gerente", 45, "Ger End", 2500, 800);
        Assert.assertEquals(3300, gerente.getSalárioBase(), 0);
    }

}