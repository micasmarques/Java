package br.com.micael;

public class Main
{
    public static void main( String[] args )
    {
        EnviarCartoes s = new EnviarCartoes();
        s.enviarCartao(new CartaoAniversário());
        s.enviarCartao(new CartaoNatalino());
        s.enviarCartao(new CartaoPascoa());
    }
}
