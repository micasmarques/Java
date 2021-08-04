package br.ifpb.edu.entities.professor;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProfessorTest {

    @Test
    public void getNumHoras() {
        Professor professor = new Professor("Novo Prof", 35, "Prof End", 1200, 50);
        Assert.assertEquals(50, professor.getNumHoras(), 0);
    }

    @Test
    public void setNumHoras() {
        Professor professor = new Professor();
        professor.setNumHoras( 10 );
        Assert.assertEquals(10, professor.getNumHoras(), 0);

        professor.setNumHoras( -1 );
        Assert.assertEquals(10, professor.getNumHoras(), 0);
    }

    @Test
    public void getSalárioBase() {
        Professor professor = new Professor("Novo Prof", 35, "Prof End", 1200, 50);
        Assert.assertEquals(1250, professor.getSalárioBase(), 0);
    }

}