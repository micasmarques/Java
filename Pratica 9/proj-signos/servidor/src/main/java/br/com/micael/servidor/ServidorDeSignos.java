package br.com.micael.servidor;

import br.com.micael.interfaces.ObjetoRemotoSignos_IF;

import java.util.*;

public class ServidorDeSignos implements ObjetoRemotoSignos_IF {

    private Map<String, List<String>> mapaSignos;

    public ServidorDeSignos() {

        /* Signos e Frases tirados de: https://joaobidu.com.br/as-frases-de-cada-signo/ */

        mapaSignos = new HashMap<>();

        mapaSignos.put("Áries",
                new ArrayList<>( Arrays.asList( "\"Você está me irritando\"",
                                                "\"Ninguém mexe comigo\"") ));

        mapaSignos.put("Touro",
                new ArrayList<>( Arrays.asList( "\"Você só pode ser meu amigo e de mais ninguém\"",
                                                "\"Tô com fome\"" ) ));

        mapaSignos.put("Gêmeos",
                new ArrayList<>( Arrays.asList( "\"Eu tenho razão\"",
                                                "\"Gosto de colocar meu ponto de vista em tudo\"" )));

        mapaSignos.put("Câncer",
                new ArrayList<>( Arrays.asList( "\"Estou triste com você\"",
                                                "\"Saudades do que tivemos\"")));

        mapaSignos.put("Leão",
                new ArrayList<>( Arrays.asList( "\"Eu nunca estive tão lindo\"",
                                                "\"Gosto de ser líder porque sei o que estou fazendo\"")));

        mapaSignos.put("Virgem",
                new ArrayList<>( Arrays.asList( "\"Deixa que eu faço, do meu jeito vai ficar melhor\"",
                                                "\"Odeio gente desorganizada\"")));

        mapaSignos.put("Libra",
                new ArrayList<>( Arrays.asList( "\"Estou confuso\"",
                                                "\"Gosto de estar sentindo bem comigo mesmo\"")));

        mapaSignos.put("Escorpião",
                new ArrayList<>( Arrays.asList( "\"Eu nunca vou esquecer o que você fez comigo\"",
                                                "\"Se não for do meu jeito eu não quero\"")));

        mapaSignos.put("Sagitário",
                new ArrayList<>( Arrays.asList( "\"Não gosto de guardar rancor\"",
                                                "\"Vamos sair para beber?\"")));

        mapaSignos.put("Capricórnio",
                new ArrayList<>( Arrays.asList( "\"Não vou gastar dinheiro com isso\"",
                                                "\"Prefiro não me apegar\"")));

        mapaSignos.put("Aquário",
                new ArrayList<>( Arrays.asList( "\"Preciso fazer mudanças na minha vida\"",

                        "\"Levanta daí e vamos correr atrás do novo\"")));

        mapaSignos.put("Peixes",
                new ArrayList<>( Arrays.asList( "\"Se precisar de ajuda é só me falar\"",
                                                "\"Vamos conversar em vez de brigar\"")));

    }

    public String getMensagemSigno(String umSigno) {
        String frase = "Signo não foi encontrado!";
        for (Map.Entry<String, List<String>> signo : mapaSignos.entrySet()) {
            if (signo.getKey().equals(umSigno)) {
                List<String> frases = signo.getValue();
                frase = frases.get((int) (Math.random() * frases.size()));
            }
        }
        return frase;
    }


}
