package com.micael;

import java.nio.file.Path;
import java.util.Set;

public class JogoPalavrasDemo {
    public static void main( String[] args )
    {
        // Cria o objeto
        JogoPalavrasCruzadas jogo = new JogoPalavrasCruzadas();

        // Lê o arquivo de texto, salva no set temporário e seta o set do Jogo.
        Set<String> setDePalavras = jogo.lerPalavrasDoArquivo( Path.of("Arquivos/palavras.txt") );
        jogo.setListaDePalavras( setDePalavras );

        // Calcula a palavra com maior pontuação
        String melhorPalavra = jogo.getMelhorPalavra();
        System.out.println("Melhor palavra (Palavra com maior pontuação): " + melhorPalavra);

        // Gera set com palavras por faixas de pontos
        int limiteInicial = 10, limiteFinal = 15;
        Set<String> palavrasPorFaixa = jogo.getPalavrasPorFaixaPontos(limiteInicial, limiteFinal);
        System.out.printf("Palavras com Pontos entre %d e %d\n", limiteFinal, limiteFinal);
        palavrasPorFaixa.forEach(
                palavra -> System.out.println("Palavra: " + palavra + " | Pontos: " + jogo.getPontosDePalavra(palavra))
        );

        // Gera mapa com palavras e seus respectivos pontos
        jogo.gravarMapaPalavras( Path.of("Arquivos/mapaDePalavras.txt") );
    }
}
