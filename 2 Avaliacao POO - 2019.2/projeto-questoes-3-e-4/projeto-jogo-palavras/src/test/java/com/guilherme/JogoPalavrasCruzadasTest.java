package com.guilherme;

import org.junit.Test;

import org.junit.*;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

public class JogoPalavrasCruzadasTest {


    @Test
    public void getPalavrasPorFaixaPontos() {
        JogoPalavrasCruzadas jogoPalavrasCruzadas = new JogoPalavrasCruzadas();

        Set<String> listaTeste = new HashSet<>();
        listaTeste.add("U");
        listaTeste.add("Guilherme");

        jogoPalavrasCruzadas.setListaDePalavras(listaTeste);
        System.out.println(jogoPalavrasCruzadas.getListaDePalavras());

        Set<String> palavrasPorFaixa = jogoPalavrasCruzadas.getPalavrasPorFaixaPontos(10, 15);

        assertThat( palavrasPorFaixa, containsInAnyOrder( "Guilherme" ) );
    }
}