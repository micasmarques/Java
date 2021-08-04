package com.micael;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

public class JogoPalavrasCruzadas {

    private Set<String> listaDePalavras;

    {
        this.setListaDePalavras( new TreeSet<>() );
    }

    public Set<String> getListaDePalavras() {
        return listaDePalavras;
    }

    public void setListaDePalavras(Set<String> listaDePalavras) {
        this.listaDePalavras = listaDePalavras;
    }

    /* --- */

    public Set<String> lerPalavrasDoArquivo( Path pathOrigem ) {

        Set<String> setDePalavras = new TreeSet<>();

        try (BufferedReader bufferedReader = new BufferedReader(
                new FileReader( String.valueOf( pathOrigem ))
        )) {
            System.out.println("Lendo palavras");
            String palavra;
            while ( (palavra = bufferedReader.readLine()) != null ) {
                setDePalavras.add( palavra );
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println("Erro! Arquivo nao encontrado!");
        } catch (IOException fne) {
            System.out.println("Erro na leitura do arquivo!");
        }

        return setDePalavras;
    }

    public int getPontosDePalavra( String umaPalavra ){
        final int[] tabelaPontos = {
                // a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p,  q, r, s, t, u, v, w, x, y, z
                   1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10 };

        ToIntFunction<String> funcao =
                palavra -> palavra.chars()
                        .map( letra -> tabelaPontos[ letra - 'a' ] )
                        .sum();

        return funcao.applyAsInt( umaPalavra );
    }

    public Map<String, Integer> mapaPontosPorPalavras() {

        Map<String, Integer> mapaPalavras = new TreeMap<>();

        getListaDePalavras().forEach(
                palavra -> {
                    mapaPalavras.put(palavra, getPontosDePalavra(palavra));
                }
        );

        return mapaPalavras;
    }

    public void gravarMapaPalavras( Path pathDestino ) {

        for (Map.Entry<String, Integer> palavra : mapaPontosPorPalavras().entrySet()) {
            try {
                Files.write(
                        pathDestino,
                        Collections.singleton(String.format("%s ; %d", palavra.getKey(), palavra.getValue())),
                        Charset.defaultCharset(),
                        StandardOpenOption.CREATE,
                        StandardOpenOption.APPEND,
                        StandardOpenOption.WRITE
                );
            } catch (IOException ioe) {
                System.out.println("Erro ao gravar arquivo!");
            }
        }

    }

    public String getMelhorPalavra() {

        int maiorPont = 0;
        String melhorPalavra = "";
        for (String palavra : getListaDePalavras()) {
            int pontos = getPontosDePalavra(palavra);
            if (pontos > maiorPont) {
                melhorPalavra = palavra;
                maiorPont = pontos;
            }
        }

        return melhorPalavra;
    }

    public Set<String> getPalavrasPorFaixaPontos( int limitePtosInicial, int limitePontosFinal ) {

        Set<String> palavrasPorFaixas = new TreeSet<>();

        for (String palavra : getListaDePalavras()) {
            int pontos = getPontosDePalavra(palavra);
            if ( pontos >= limitePtosInicial && pontos <= limitePontosFinal) {
                palavrasPorFaixas.add(palavra);
            }
        }

        return palavrasPorFaixas;
    }
}
